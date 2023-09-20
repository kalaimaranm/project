
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Brand;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.BrandRepository;
import com.bassure.ims.productservice.request.BrandRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.BrandService;
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
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private HttpStatusCode httpStatusCode;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandId(sequenceGeneratorService.generateSequence(UtilsConfig.getBRAND_SEQUENCE_NAME()));
        BeanUtils.copyProperties(brandRequest, brand);
        brand.setCreatedAt(LocalDateTime.now());
        Brand savedBrand = brandRepo.save(brand);
        if (Objects.nonNull(savedBrand.getBrandName())) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "added success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of());
        }
    }

    @Override
    public ResponseEntity updateBrand(String brandId, BrandRequest brandRequest) {
        Optional<Brand> optionalBrand = brandRepo.findById(brandId);
        if (optionalBrand.isPresent()) {
            Brand brand = new Brand();
            brand.setBrandId(optionalBrand.get().getBrandId());
            BeanUtils.copyProperties(brandRequest, brand);
            brandRepo.save(brand);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "updated success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity getBrandById(String brandId) {
        Optional<Brand> optionalBrand = brandRepo.findById(brandId);
        if (optionalBrand.isPresent()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), optionalBrand);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity getAllBrand() {
        List<Brand> brandList = brandRepo.findAll();
        if (!brandList.isEmpty()) {
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), brandList);
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    public ResponseEntity deleteBrand(String brandId) {

       if(getBrandById(brandId).getCode() == httpStatusCode.getSuccess()) {

           Query query = new Query(Criteria.where("id").is(brandId));
           Update update = new Update().set("status", "INACTIVE");
           UpdateResult result = mongoTemplate.updateFirst(query, update, Brand.class);
           if (result.getModifiedCount() > 0) {
               return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "product deleted successfully");
           }
       }
        return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of("", "product failed to delete id - "+brandId));

    }


}
