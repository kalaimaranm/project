
package com.bassure.ims.productservice.collection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "brand")
public class Brand {
    
    @Id
    private String brandId;

    @Field(value = "brand_name")
    @Indexed(unique = true)
    private String brandName;

    @Field(value = "created_at")
    private LocalDate createdAt;

    @Field(value = "updated_at")
    private LocalDate updatedAt;


    
}
