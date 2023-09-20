package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Asset;
import com.bassure.ims.productservice.collection.Warranty;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.HttpStatusMessage;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.AssetRepository;
import com.bassure.ims.productservice.repository.BrandRepository;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.repository.OrderRepository;
import com.bassure.ims.productservice.request.AssetRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.AssetService;

import java.time.LocalDateTime;
import java.util.*;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private HttpStatusCode httpStatusCode;

    @Autowired
    private HttpStatusMessage httpStatusMessage;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addAsset(AssetRequest assetsRequest) {
        Asset anAsset = new Asset();
        BeanUtils.copyProperties(assetsRequest, anAsset);
        anAsset.setAssetId(sequenceGeneratorService.generateSequence(UtilsConfig.getASSET_SEQUENCE_NAME()));
        Warranty warranty = new Warranty();
        warranty.setStartDate(assetsRequest.getWarranty().getStartDate());
        warranty.setEndDate(assetsRequest.getWarranty().getEndDate());
        warranty.setStatus(assetsRequest.getWarranty().getStatus());
        anAsset.setWarranty(warranty);
        anAsset.setCreatedAt(LocalDateTime.now());
        anAsset.setStatus("ACTIVE");
        if (brandRepository.findById(anAsset.getBrandId()).isPresent() &&
                modelRepository.findById(anAsset.getModelId()).isPresent() &&
                orderRepository.findById(anAsset.getOrderId()).isPresent()) {
            assetRepository.save(anAsset);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), httpStatusMessage.getAddMessage());
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of(httpStatusMessage.getErrorKey(), ""));
        }
    }

    @Override
    public ResponseEntity getAsset() {
        List<Asset> all = assetRepository.findAll();
        if (!all.isEmpty()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), all);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity getAssetById(String assetId) {
        Optional<Asset> asset = assetRepository.findById(assetId);
        if (asset.isPresent()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), asset);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity getAggregatedAssets() {
        List<Asset> assets = assetRepository.retrieveAggregatedAssets();
        if (!assets.isEmpty()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), assets);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity retrieveAggregatedAsset() {
        LookupOperation lookupBrand = LookupOperation.newLookup()
                .from("brand")
                .localField("brand_id")
                .foreignField("_id")
                .as("brandData");

        LookupOperation lookupOrder = LookupOperation.newLookup()
                .from("Order")
                .localField("order_id")
                .foreignField("_id")
                .as("orderData");

        UnwindOperation unwindOrder = Aggregation.unwind("orderData");

        List<AggregationOperation> supplierPipeline = new ArrayList<>();
        supplierPipeline.add(Aggregation.replaceRoot("orderData"));

        LookupOperation lookupSupplier = LookupOperation.newLookup()
                .from("supplier")
                .localField("supplier_id")
                .foreignField("_id")
                .as("supplierData");

//        AggregationOperation lookupSupplierOperation = Aggregation.lookup("Order")
//                .applyAggregationOperations(supplierPipeline)
//                .applyAggregationOperation(lookupSupplier)
//                .as("supplierData");
//        Aggregation aggregation = Aggregation.newAggregation(
//                lookupBrand,
//                lookupOrder,
//                unwindOrder,
//                lookupSupplierOperation
//        );
        Aggregation aggregation = null;

        List<Asset> product = mongoTemplate.aggregate(aggregation, "product", Asset.class).getMappedResults();
        if (!product.isEmpty()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), product);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity updateAsset(String assetId, AssetRequest anAssetRequest) {
        Optional<Asset> optionalAsset = assetRepository.findById(assetId);
        if (optionalAsset.isPresent()) {
            Asset anAsset = new Asset();
            anAsset.setAssetId(optionalAsset.get().getAssetId());
            BeanUtils.copyProperties(anAssetRequest, anAsset);
            assetRepository.save(anAsset);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "updated success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }


    @Override
    public ResponseEntity deleteAsset(String assetId) {
        if (getAssetById(assetId).getCode() == httpStatusCode.getSuccess()) {

            Query query = new Query(Criteria.where("id").is(assetId));
            Update update = new Update().set("status", "INACTIVE");
            UpdateResult result = mongoTemplate.updateFirst(query, update, Asset.class);
            if (result.getModifiedCount() > 0) {
                return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "Asset deleted successfully");
            }
        }
        return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of("", "Asset failed to delete id - " + assetId));

    }
}
