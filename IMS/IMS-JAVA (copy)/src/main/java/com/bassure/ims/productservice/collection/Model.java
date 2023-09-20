package com.bassure.ims.productservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Data
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
    private LocalDateTime updatedAt;

    @Field(value = "category_id")
    private String categoryId;
}
