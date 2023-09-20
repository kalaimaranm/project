package com.bassure.ims.productservice.request;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepreciationRequest {

    @NotNull(message = "Initial value is required")
    @Min(value = 1, message = "Initial value must be a positive number or zero")
    private Double initialValue;

    @NotNull(message = "Depreciation value is required")
    @PositiveOrZero(message = "Depreciation value must be a positive number or zero")
    private Double depreciationValue;

    @NotBlank(message = "Depreciation year is required")
    @Size(min = 4, max = 4, message = "Depreciation year must be a 4-digit number")
    private String depreciationYear;

}
