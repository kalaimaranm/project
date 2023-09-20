package com.bassure.ims.productservice.response;

import java.util.Map;
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
public class ModelResponse {

    private String modelId;

    private String modelName;

    private Map<String, String> specification;

    private String categoryId;

}
