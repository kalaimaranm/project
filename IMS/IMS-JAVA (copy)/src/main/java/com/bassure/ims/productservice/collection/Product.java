package com.bassure.ims.productservice.collection;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String productId;

    @NotNull
    @Field(value = "product_name")
    private String productName;

    @NotNull
    @Field(value = "product_desc")
    private String productDesc;

    
    @NotNull
    @Field(value = "price")
    private double price;

    
    @Field(value = "serial_no")
    private String serialNo;

    @Field(value = "ownership")
    private String ownership;
    
    
    @Field(value = "tenant_id")
    private String tenantId;

    @Field(value = "brand_id")
    private String brandId;

    @Field(value = "model_id")
    private String modelId;

    @Field(value = "order_id")
    private String orderId;
    
    @Field(value = "warranty")
    private Warranty warranty;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    private LocalDateTime updatedAt;

    @Field(value = "status")
    private String status;
}