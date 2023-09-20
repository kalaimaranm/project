package com.bassure.ims.productservice.request;

import com.bassure.ims.productservice.collection.Warranty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequest {

    @NotBlank
//    @NotNull
    private String productName;

    
    private String productDesc;

    private double price;

    private String serialNo;

    private String ownership;

    private String tenantId;

    private String brandId;

    private String modelId;

    private String orderId;

    private WarrantyRequest warranty;

}
