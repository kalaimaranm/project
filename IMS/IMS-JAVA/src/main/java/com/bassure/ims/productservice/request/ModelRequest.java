package com.bassure.ims.productservice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelRequest {

    @NotBlank(message = "Model name is required")
    private String modelName;

    @NotNull(message = "Specification is required")
    @NotEmpty(message = "Specification must not be empty")
    private Map<String, String> specification;

    @NotBlank(message = "Category ID is required")
    @Size(min = 1, max = 255, message = "Category ID must be between 1 and 255 characters")
    private String categoryId;

    @NotBlank(message = "Brand ID is required")
    @Size(min = 1, max = 255, message = "Category ID must be between 1 and 255 characters")
    private String brandId;
}
