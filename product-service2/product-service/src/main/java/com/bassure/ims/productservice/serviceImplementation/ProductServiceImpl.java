
package com.bassure.ims.productservice.serviceImplementation;

import com.bassure.ims.productservice.collection.Product;
import com.bassure.ims.productservice.repository.ProductRepository;
import com.bassure.ims.productservice.service.ProductService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
   public Product addProduct(Product product){
        if(product==null){
            throw new IllegalArgumentException("Some field in Product must not be empty.");
        }
        LocalDate date=LocalDate.now();
        product.setCreatedAt(date);  
        return productRepository.save(product);
    }
   
   
   @Override
   public List<Product> getProduct(){
       return productRepository.findAll();  
   }
   
     @Override
      public Product getProductById(String productId){
         Optional<Product> product= productRepository.findById(productId);
         return product.get();
   }
      
         @Override
         public List<Product> getAggregatedProducts() {
        return productRepository.retrieveAggregatedProducts();
    }
         
         
         @Override
         public List<Product> retrieveAggregatedProducts() {
               LookupOperation brandLookup = LookupOperation.newLookup()
                      .from("brand")
                .localField("brand_id")
                .foreignField("_id")
                .as("brandData"); 
//               LookupOperation modellookup = LookupOperation.newLookup()
//                .from("model")
//                .localField("model_id")
//                .foreignField("_id")
//                .as("modelData");

        ProjectionOperation project = Aggregation.project(
                "_id", "product_name", "product_desc", "price", "serial_no", "ownership",
                "tenant_id", "brand_id", "model_id", "order_id", "warranty", "created_at",
                "created_by", "updated_by", "status", "brandData"
        );

        Aggregation aggregation = Aggregation.newAggregation(brandLookup, project);

        return mongoTemplate.aggregate(aggregation, "product", Product.class).getMappedResults();
     
    }
}
