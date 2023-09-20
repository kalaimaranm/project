package com.bassure.ims.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AssertResponse {

    private String productId;

    private String productName;

    private String productDesc;

    private double price;

    private String serialNo;

    private String ownership;

    private String tenantId;

    private String brandId;

    private String modelId;

    private String orderId;

    private WarrantyResponse warranty;


}
