package com.bassure.ims.productservice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class WarrantyRequest {

    @NotBlank(message = "Start date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Start date should be in the format YYYY-MM-DD")
    private String startDate;

    @NotBlank(message = "End date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "End date should be in the format YYYY-MM-DD")
    private String endDate;

    @NotBlank(message = "Status is required")
    private String status;
}
