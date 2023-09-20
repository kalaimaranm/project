package com.bassure.ims.productservice.config;

import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;

import java.util.Map;

public class UtilsResponse {

    public static ResponseEntity responsesEntity(int code, Object value, Map<String, String> error) {
        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(code).build())
                .body(ResponseBody.builder().value(value).error(error).build())
                .build();
    }
}
