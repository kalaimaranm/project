package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.serviceImpl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/model/")
public class ModelController {

    @Autowired
    private ModelServiceImpl modelServiceImpl;
//    @GetMapping("/getModels")
//    public ResponseEntity getModels() {
//    }
}
