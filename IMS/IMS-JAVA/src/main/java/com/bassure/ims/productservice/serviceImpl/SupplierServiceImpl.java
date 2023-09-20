package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Address;
import com.bassure.ims.productservice.collection.Supplier;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.SupplierRepository;
import com.bassure.ims.productservice.request.SupplierRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.SupplierService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private HttpStatusCode httpStatusCode;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addSupplier(SupplierRequest supplierRequest) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierRequest, supplier);
        supplier.setSupplierId(sequenceGeneratorService.generateSequence(UtilsConfig.getSUPPLIER_SEQUENCE_NAME()));
        Address address=new Address();
        address.setCity(supplierRequest.getAddress().getCity());
        address.setCountry(supplierRequest.getAddress().getCountry());
        address.setState(supplierRequest.getAddress().getState());
        address.setPostalCode(supplierRequest.getAddress().getPostalCode());
        supplier.setCreatedAt(LocalDateTime.now());
        supplier.setAddress(address);
        supplier.setStatus("ACTIVE");
        Supplier saved = supplierRepository.save(supplier);

        if (!Objects.isNull(saved.getName())) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "added success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of());
        }
    }

    @Override
    public ResponseEntity getSupplierById(String supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), optionalSupplier);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of());
        }
    }

    @Override
    public ResponseEntity getAllSupplier() {
        List<Supplier> supplierList = supplierRepository.findAll();
        if (!supplierList.isEmpty()){
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), supplierList);
        }else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity deleteSupplierById(String supplierId) {
        if(getSupplierById(supplierId).getCode() == httpStatusCode.getSuccess()) {
            Query query = new Query(Criteria.where("id").is(supplierId));
            Update update = new Update().set("status", "INACTIVE");
            UpdateResult result = mongoTemplate.updateFirst(query, update, Supplier.class);

            if(result.getModifiedCount() > 0) {
                return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "supplier deleted successfully");
            }
        }
        return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of("", "failed to delete supplier id "+ supplierId));
    }

    @Override
    public ResponseEntity updateSupplier(String supplierId, SupplierRequest supplierRequest) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()){
            Supplier supplier = new Supplier();
            supplier.setSupplierId(optionalSupplier.get().getSupplierId());
            BeanUtils.copyProperties(supplierRequest, supplier);
            supplierRepository.save(supplier);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "updated success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }
}
