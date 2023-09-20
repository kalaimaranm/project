package com.bassure.ims.productservice.collection;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "category")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String categoryId;

    @Field(value = "category_name")
    @Indexed(unique = true)
//    @NotBlank(message = "Empty ")
//    @Size(min = 3 ,max = 44, message = "Name must be between {min} and {max}")
    private String categoryName;

    @Field(value = "parentCategory_id")
    private String parentCatagoryId;

    @Field(value = "created_at")
    private LocalDateTime createdAt;

    @Field(value = "updated_at")
    private LocalDateTime updatedAt;
}
