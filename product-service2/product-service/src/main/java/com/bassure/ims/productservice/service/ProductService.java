package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.collection.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getProduct();

    Product getProductById(String productId);

    List<Product> getAggregatedProducts();

    List<Product> retrieveAggregatedProducts();
}
