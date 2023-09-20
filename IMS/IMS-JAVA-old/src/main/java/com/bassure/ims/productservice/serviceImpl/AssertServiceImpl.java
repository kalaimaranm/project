package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Assert;
import com.bassure.ims.productservice.collection.Rental;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.repository.AssertRepository;
import com.bassure.ims.productservice.request.AssertRequest;
import com.bassure.ims.productservice.service.AssertService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Service;

@Service
public class AssertServiceImpl implements AssertService {

    @Autowired
    private AssertRepository assertRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Assert addAssert(AssertRequest assertsRequest) {
        try {
            Assert anAssert = new Assert();
            anAssert.setAssertId(sequenceGeneratorService.generateSequence(UtilsConfig.getPRODUCT_SEQUENCE_NAME()));
            BeanUtils.copyProperties(assertsRequest, anAssert);
            return assertRepository.save(anAssert);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Assert> getAssert() {
        return assertRepository.findAll();
    }

    @Override
    public Assert getAssertById(String productId) {
        Optional<Assert> product = assertRepository.findById(productId);
        return product.orElseThrow();
    }

    @Override
    public List<Assert> getAggregatedProducts() {
        return assertRepository.retrieveAggregatedProducts();
    }

    @Override
    public List<Assert> retrieveAggregatedAssert() {
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

        return mongoTemplate.aggregate(aggregation, "product", Assert.class).getMappedResults();
    }

    @Override
    public String updateAssert(String assertId, AssertRequest anAssertRequest) {
        Optional<Assert> optionalAssert = assertRepository.findById(assertId);
        if (optionalAssert.isPresent()) {
            Assert anAssert = new Assert();
            anAssert.setAssertId(assertId);
            BeanUtils.copyProperties(anAssertRequest, anAssert);
            assertRepository.save(anAssert);
            return "assert updated successfully";
        } else {
            return null;
        }
    }
}
