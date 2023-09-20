
package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Rental;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.RentalRepository;
import com.bassure.ims.productservice.request.RentalRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.RentalService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepo;

    @Autowired
    private HttpStatusCode httpStatusCode;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addRental(RentalRequest rentalRequest) {
        Rental rental = new Rental();
        rental.setRentalId(sequenceGeneratorService.generateSequence(UtilsConfig.getRENTAL_SEQUENCE_NAME()));
        BeanUtils.copyProperties(rentalRequest, rental);
        Rental saved = rentalRepo.save(rental);
        if (Objects.nonNull(saved.getAssetId())){
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "added success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of());
        }
    }

    @Override
    public ResponseEntity getAllRental() {
        List<Rental> rentalList = rentalRepo.findAll();
        if (!rentalList.isEmpty()){
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), rentalList);
        }else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity getRental(String rentalId) {
        Optional<Rental> optionalRental = rentalRepo.findById(rentalId);
        if (optionalRental.isPresent()){
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), optionalRental);
        }else {
            return UtilsResponse.responsesEntity(httpStatusCode.getError(), Map.of());
        }
    }

    @Override
    public ResponseEntity updateRental(String rentalId, RentalRequest rentalRequest) {
        Optional<Rental> optionalRental = rentalRepo.findById(rentalId);
        if(optionalRental.isPresent()){
            Rental rental = new Rental();
            rental.setRentalId(optionalRental.get().getRentalId());
            BeanUtils.copyProperties(rentalRequest, rental);
            rentalRepo.save(rental);
            return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "updated success");
        } else {
            return UtilsResponse.responsesEntity(httpStatusCode.getNoData(), Map.of());
        }
    }

    @Override
    public ResponseEntity deleteRental(String rentalId) {

        if(getRental(rentalId).getCode() == httpStatusCode.getSuccess()) {
         Query query = new Query(Criteria.where("id").is(rentalId));
         Update update = new Update().set("status", "INACTIVE");
         UpdateResult result = mongoTemplate.updateFirst(query, update, Rental.class);
         if(result.getModifiedCount() > 0) {

             return UtilsResponse.responsesEntity(httpStatusCode.getSuccess(), "rental deleted successfully");
         }

        }
        return UtilsResponse.responsesEntity(httpStatusCode.getFailed(), Map.of("", "rental failed to delete"));
    }

}
