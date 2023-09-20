package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Category;
import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.request.ModelRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.ModelService;
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
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private HttpStatusCode status;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity getAllModel() {
        List<Model> modelList = modelRepository.findAll();
        if (!modelList.isEmpty()) {
            return UtilsResponse.responsesEntity(status.getSuccess(), modelList);
        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of("", ""));
    }

    @Override
    public ResponseEntity updateModel(String id, ModelRequest modelRequest) {
        Optional<Model> isExists = modelRepository.findById(id);
        if (isExists.isPresent()) {
            Model model = new Model();
            model.setModelId(isExists.get().getModelId());
            BeanUtils.copyProperties(modelRequest, model);
            Model updatedModel = modelRepository.save(model);
            if (updatedModel.getModelId() != null) {
                return UtilsResponse.responsesEntity(status.getSuccess(), updatedModel);
            }
        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of());
    }

    @Override
    public ResponseEntity addModel(ModelRequest modelRequest) {
        Model model = new Model();
        model.setModelId(sequenceGeneratorService.generateSequence(UtilsConfig.getMODEL_SEQUENCE_NAME()));
        model.setCreatedAt(LocalDateTime.now());
        BeanUtils.copyProperties(modelRequest, model);
        model.setStatus("ACTIVE");
        Model addModel = modelRepository.save(model);
        if (!Objects.isNull(addModel.getModelName())) {
            return UtilsResponse.responsesEntity(status.getSuccess(), "model added successfully id - " + addModel.getModelId());
        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of());
    }

    @Override
    public ResponseEntity getModel(String id) {
        Optional<Model> getModel = modelRepository.findById(id);
        if (getModel.isPresent()) {
            return UtilsResponse.responsesEntity(status.getSuccess(), getModel.get());
        }
        return UtilsResponse.responsesEntity(status.getError(), Map.of("", ""));
    }

    public ResponseEntity deleteModel(String id) {

        if (getModel(id).getCode() == status.getSuccess()) {

            Query query = new Query(Criteria.where("id").is(id));
            Update update = new Update().set("status", "INACTIVE");
            UpdateResult result = mongoTemplate.updateFirst(query, update, Category.class);

            if (result.getModifiedCount() > 0) {
                return UtilsResponse.responsesEntity(status.getSuccess(), "category deleted successfully");
            }
        }

        return UtilsResponse.responsesEntity(status.getFailed(), Map.of("", "failed to delete category id - " + id));
    }

}
