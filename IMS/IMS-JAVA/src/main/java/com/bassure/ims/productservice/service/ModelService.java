package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.ModelRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface ModelService {

     ResponseEntity getAllModel();

     ResponseEntity updateModel(String id, ModelRequest modelRequest);

     ResponseEntity addModel(ModelRequest model);

     ResponseEntity getModel(String id);

     ResponseEntity deleteModel(String id);

}
