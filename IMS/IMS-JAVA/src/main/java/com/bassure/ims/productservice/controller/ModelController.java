package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.ModelRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.serviceImpl.ModelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    @Autowired
    private ModelServiceImpl modelService;

    @PostMapping("/addmodel")
    public ResponseEntity saveModels(@Valid @RequestBody ModelRequest modelRequest) {
        return modelService.addModel(modelRequest);

    }

    @GetMapping("/getmodel/{id}")
    public ResponseEntity getModel(@PathVariable String id) {

        return modelService.getModel(id);
    }

    @GetMapping("/getallmodel")
    public ResponseEntity getAllModel() {

        return modelService.getAllModel();
    }

    @PutMapping("/updatemodel/{id}")
    public ResponseEntity updateModel(@PathVariable String id, @RequestBody ModelRequest modeRequest) {
        return modelService.updateModel(id, modeRequest);
    }

    @DeleteMapping("/deletemodel/{id}")
    public ResponseEntity deleteModel(@PathVariable String id) {

        return modelService.deleteModel(id);
    }

}
