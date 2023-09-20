package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.request.AssetRequest;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assert")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping("/addasset")
    public ResponseEntity addProduct(@Valid @RequestBody AssetRequest anAsset) {
        return assetService.addAsset(anAsset);
    }

    @GetMapping("/getallasset")
    public ResponseEntity findAllProducts() {
        return assetService.getAsset();
    }

    @GetMapping("assetbyid/{assetId}")
    public ResponseEntity findProductById(@PathVariable String assetId) {
        return assetService.getAssetById(assetId);
    }

    @GetMapping("/aggregatedProducts")
    public ResponseEntity retrieveAggregatedProducts() {
        return assetService.retrieveAggregatedAsset();
    }


    @PutMapping("/updateProduct/{assertId}")
    public ResponseEntity updateAssert(@PathVariable String assertId, @RequestBody AssetRequest anAssetRequest) {
        return assetService.updateAsset(assertId, anAssetRequest);
    }

    @DeleteMapping("/deleteasset/{id}")
    public ResponseEntity deleteAssert(@PathVariable String id) {

        return assetService.deleteAsset(id);
    }

}
