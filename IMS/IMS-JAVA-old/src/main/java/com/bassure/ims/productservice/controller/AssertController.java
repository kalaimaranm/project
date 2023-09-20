package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Assert;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.request.AssertRequest;
import com.bassure.ims.productservice.service.AssertService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assert")
public class AssertController {

    @Autowired
    private AssertService assertService;



    @PostMapping("/addassert")
    public ResponseEntity addProduct(@RequestBody AssertRequest anAssert) {
        Assert addAssert = assertService.addAssert(anAssert);
        if (addAssert.getBrandId() != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(addAssert).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build())
                    .build();
        }
    }

    @GetMapping("/getallassert")
    public ResponseEntity findAllProducts() {
        List<Assert> anAssert = assertService.getAssert();
        if (!anAssert.isEmpty()) {
            return UtilsResponse.responsesEntity(UtilsConfig.getSUCCESS_CODE(), anAssert, null);
        } else {
            return UtilsResponse.responsesEntity(UtilsConfig.getERROR_CODE(), null, Map.of("","No data found"));
        }
    }

    @GetMapping("assertbyid/{assertId}")
    public Assert findProductById(@PathVariable String assertId) {
        return assertService.getAssertById(assertId);
    }

//    @GetMapping("/aggregatedProducts")
//    public List<Assert> getAggregatedProducts() {
//        return assertService.getAggregatedProducts();
//    }

    @GetMapping("/aggregatedProducts")
    public ResponseEntity retrieveAggregatedProducts() {
        List<Assert> anAssert = assertService.retrieveAggregatedAssert();
        if (!anAssert.isEmpty()) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(anAssert).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("", "")).build())
                    .build();
        }
    }


    @PutMapping("/updateProduct/{assertId}")
    public ResponseEntity updateAssert(@PathVariable String assertId, @RequestBody AssertRequest anAssertRequest) {
        String updateAssert = assertService.updateAssert(assertId, anAssertRequest);
        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                .body(ResponseBody.builder().value(updateAssert).build())
                .build();    }

}
