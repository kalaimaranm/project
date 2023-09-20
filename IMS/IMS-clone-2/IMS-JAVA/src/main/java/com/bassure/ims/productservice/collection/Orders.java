
package com.bassure.ims.productservice.collection;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Order")
public class Orders {
     
    @Id
    private  String orderId;
    
    @Field(value = "order_date")
    private  LocalDateTime orderDate;
    
    @Field(value = "creted_at")
    private  LocalDateTime createAt;
    
    @Field(value = "updated_at")
    private  LocalDateTime updatedAt;
    
    @Field(value = "supplier_id")
    private String supplierId;
    
    
   
}
