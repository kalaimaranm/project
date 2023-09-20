package com.bassure.ims.productservice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @NotNull(message = "Order date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Start date should be in the format YYYY-MM-DD")
    private LocalDateTime orderDate;

    @NotBlank(message = "Supplier ID is required")
    private String supplierId;

}
