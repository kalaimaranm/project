package com.bassure.ims.productservice.serviceImpl;

import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.repository.ModelRepository;
import com.bassure.ims.productservice.request.ModelRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.ModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Override
//    public ResponseEntity addModel(ModelRequest modelRequest) {
//        Model model= new Model();
//        BeanUtils.copyProperties(modelRequest, model);
//        return modelRepository.save(model);
//    }
//
//    @Override
//    public Model updateModel(Model model) {
//        Optional<Model> isExists = modelRepository.findById(model.getModelId());
//        if (isExists.isPresent()) {
//
//            Model existModel = isExists.get();
//            existModel.setModelName(model.getModelName());
//
//            //To update the specification and can add new specification
//            Map<String, String> existingSpecification = existModel.getSpecification();
//            Map<String, String> updatedSpecification = existModel.getSpecification();
//            existingSpecification.putAll(updatedSpecification);
//
//            existModel.setSpecification(existingSpecification);
//
//            existModel.setCategoryId(model.getCategoryId());
//            existModel.setBrandId(model.getBrandId());
////            existModel.setUpdatedAt(LocalDateTime.now());
//            return modelRepository.save(existModel);
//
//        }
//        return isExists.get();
//    }
//
//    @Override
//    public List<Model> getModels() {
//
//        ResponseEntity response = UtilsResponse.responsesEntity(status.getSuccess(),);
//
//    }
    @Override
    public ResponseEntity getAllModel() {

        List<Model> model = modelRepository.findAll();

        if (model != null) {

            return UtilsResponse.responsesEntity(status.getSuccess(), model, null);

        }

        return UtilsResponse.responsesEntity(status.getError(), null, Map.of("", ""));

    }

    @Override
    public ResponseEntity updateModel(String id, ModelRequest model) {

        Optional<Model> isExists = modelRepository.findById(id);
        if (isExists.isPresent()) {

            Model existModel = isExists.get();
            existModel.setModelName(model.getModelName());

            //To update the specification and can add new specification
            Map<String, String> existingSpecification = existModel.getSpecification();
            Map<String, String> updatedSpecification = existModel.getSpecification();
            existingSpecification.putAll(updatedSpecification);

            existModel.setSpecification(existingSpecification);

            existModel.setCategoryId(model.getCategoryId());
            existModel.setBrandId(model.getBrandId());
            Model updatedModel = modelRepository.save(existModel);

            if (updatedModel.getModelId() != null) {
                return UtilsResponse.responsesEntity(status.getSuccess(), "added success", null);

            }

        }
        return UtilsResponse.responsesEntity(status.getError(), "failed to update model", Map.of());

    }

    @Override
    public ResponseEntity addModel(ModelRequest modelRequest) {

        Model model = new Model();
        model.setModelId(sequenceGeneratorService.generateSequence(UtilsConfig.getMODEL_SEQUENCE_NAME()));
        BeanUtils.copyProperties(modelRequest, model);
        Model addModel = modelRepository.save(model);

        if (Objects.isNull(addModel)) {

            return UtilsResponse.responsesEntity(status.getSuccess(), "added success", null);

        }

        return UtilsResponse.responsesEntity(status.getError(), "failed to add model", null);

    }

    @Override
    public ResponseEntity getModel(String id) {

        Optional<Model> getModel = modelRepository.findById(id);

        if (getModel.isPresent()) {

            return UtilsResponse.responsesEntity(status.getSuccess(), getModel.get(), Map.of());
        }
        return UtilsResponse.responsesEntity(status.getError(), "model not found id - " + id, Map.of("", ""));

    }

}
