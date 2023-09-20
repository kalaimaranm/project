package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.BrandRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.serviceImpl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    BrandServiceImpl brandService;

    @PostMapping("/addbrand")
    public ResponseEntity addBrand(@RequestBody BrandRequest brandRequest) {
        return brandService.addBrand(brandRequest);
    }

    @GetMapping("/getallbrand")
    public ResponseEntity getAllBrand() {
        return brandService.getAllBrand();
    }

    @PutMapping("/updatebrand/{brandId}")
    public ResponseEntity updateBrand(@PathVariable String brandId, BrandRequest brandRequest) {
        return brandService.updateBrand(brandId, brandRequest);
    }

    @GetMapping("/brandbyid/{brandId}")
    public ResponseEntity getBrand(@PathVariable String brandId){
        return brandService.getBrandById(brandId);
    }

    @DeleteMapping("/deletebrand/{id}")
    public ResponseEntity deleteBrand(@PathVariable String id) {

        return brandService.deleteBrand(id);
    }
}
