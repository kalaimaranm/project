package com.bassure.ims.productservice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class TenantRequest {

    @Positive(message = "Tenant ID must be a positive integer")
    private int tenantId;

    @NotBlank(message = "Tenant name is required")
    private String tenantName;
}
