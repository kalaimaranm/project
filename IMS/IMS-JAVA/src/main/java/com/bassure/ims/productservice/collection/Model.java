package com.bassure.ims.productservice.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "model")
public class Model {

    @Id
    private String modelId;

    @Field(value = "model_name")
    private String modelName;

    @Field(value = "specification")
    private Map<String, String> specification;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Field(value = "category_id")
    private String categoryId;

    @Field(value = "brand_id")
    private String brandId;

    @Field(value = "status")
    private String status;
}
