package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "assert")
public class Assert {

    @Id
    private String AssertId;

    @Field(value = "assert_name")
    private String AssertName;

    @Field(value = "product_desc")
    private String productDesc;

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
    @CreatedDate
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "created_by")
    @CreatedBy
    private LocalDateTime createdBy;

    @Field(value = "updated_by")
    @LastModifiedBy
    private LocalDateTime updatedBy;

    @Field(value = "status")
    private String status;

}
