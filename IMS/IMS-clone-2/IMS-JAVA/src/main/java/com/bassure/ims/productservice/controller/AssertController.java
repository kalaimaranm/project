package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Assert;
import com.bassure.ims.productservice.collection.ResponseBody;
import com.bassure.ims.productservice.collection.ResponseEntity;
import com.bassure.ims.productservice.collection.ResponseHeader;
import com.bassure.ims.productservice.config.UtilsConfig;
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
@RequestMapping("/assert")
public class AssertController {

    @Autowired
    AssertService assertService;

    @PostMapping("/addassert")
    public ResponseEntity addProduct(@RequestBody Assert anAssert) {
        Assert addAssert = assertService.addAssert(anAssert);
        if (addAssert.getBrandId() != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(addAssert).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("","")).build())
                    .build();
        }
    }

    @GetMapping("/getallassert")
    public ResponseEntity findAllProducts() {
        List<Assert> anAssert = assertService.getAssert();
        if (!anAssert.isEmpty()) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(anAssert).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("","")).build())
                    .build();
        }
    }

    @GetMapping("/{productId}")
    public Assert findProductById(@PathVariable String productId) {
        return assertService.getAssertById(productId);
    }

//     @GetMapping("/aggregatedProducts")
//    public List<Product> getAggregatedProducts() {
//        return productService.getAggregatedProducts();
//    }
    @GetMapping("/aggregatedProducts")
    public ResponseEntity retrieveAggregatedProducts() {
        List<Assert> anAssert = assertService.retrieveAggregatedAssert();
        if(!anAssert.isEmpty()){
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(anAssert).build())
                    .build();
        }
        else{
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("","")).build())
                    .build();
        }
    }
    
    
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody Assert anAssert){
        return ResponseEntity.builder().build();
        
    }

}
