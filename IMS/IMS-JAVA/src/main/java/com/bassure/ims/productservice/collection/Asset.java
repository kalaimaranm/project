package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "asset")
public class Asset {

    @Id
    private String assetId;

    @Field(value = "asset_name")
    private String assetName;

    @Field(value = "asset_desc")
    private String assetDesc;

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
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "created_by")
    private String createdBy;

    @Field(value = "updated_by")
    private String updatedBy;

    @Field(value = "status")
    private String status;

}
