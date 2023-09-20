package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Product;
import com.bassure.ims.productservice.collection.ResponseBody;
import com.bassure.ims.productservice.collection.ResponseEntity;
import com.bassure.ims.productservice.collection.ResponseHeader;
import com.bassure.ims.productservice.config.UtilsConfig;
import com.bassure.ims.productservice.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity addProduct(@RequestBody Product product) {
        Product addProduct = productService.addProduct(product);
        if (addProduct.getBrandId() != null) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(addProduct).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("","")).build())
                    .build();
        }
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity findAllProducts() {
        List<Product> product = productService.getProduct();
        if (!product.isEmpty()) {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(product).build())
                    .build();
        } else {
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getERROR_CODE()).build())
                    .body(ResponseBody.builder().error(Map.of("","")).build())
                    .build();
        }
    }

    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

//     @GetMapping("/aggregatedProducts")
//    public List<Product> getAggregatedProducts() {
//        return productService.getAggregatedProducts();
//    }
    @GetMapping("/aggregatedProducts")
    public ResponseEntity retrieveAggregatedProducts() {
        List<Product> product= productService.retrieveAggregatedProducts();
        if(!product.isEmpty()){
            return ResponseEntity.builder()
                    .header(ResponseHeader.builder().code(UtilsConfig.getSUCCESS_CODE()).build())
                    .body(ResponseBody.builder().value(product).build())
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
    public ResponseEntity updateProduct(@RequestBody Product product){
        return ResponseEntity.builder().build();
        
    }

}
