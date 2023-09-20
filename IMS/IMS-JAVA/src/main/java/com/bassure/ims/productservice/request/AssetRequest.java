package com.bassure.ims.productservice.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class AssetRequest {

    @NotBlank(message = "productName is required")
    private String assetName;

    private String assetDesc;

    @Positive(message = "price must be a positive number")
    @NotNull(message = "price is required")
    private double price;

    private String serialNo;

    @NotBlank(message = "ownership is required")
    private String ownership;

    @NotBlank(message = "tenantId is required")
    private String tenantId;

    @NotBlank(message = "brandId is required")
    private String brandId;

    @NotBlank(message = "modelId is required")
    private String modelId;

    private String orderId;

    @Valid // To validate the embedded WarrantyRequest
    private WarrantyRequest warranty;
}
