package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Model;
import com.bassure.ims.productservice.request.ModelRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface ModelService {

    public ResponseEntity getAllModel();

    public ResponseEntity updateModel(String id, ModelRequest modelRequest);

    public ResponseEntity addModel(ModelRequest model);

    public ResponseEntity getModel(String id);

}
