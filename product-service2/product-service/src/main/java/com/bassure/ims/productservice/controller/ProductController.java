package com.bassure.ims.productservice.controller;

import com.bassure.ims.productservice.collection.Product;
import com.bassure.ims.productservice.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getProduct();
    }

    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

//     @GetMapping("/aggregatedProducts")
//    public List<Product> getAggregatedProducts() {
//        return productService.getAggregatedProducts();
//    }
    @GetMapping("aggregatedProducts")
    public List<Product> retrieveAggregatedProducts() {
        return productService.retrieveAggregatedProducts();
    }

}
