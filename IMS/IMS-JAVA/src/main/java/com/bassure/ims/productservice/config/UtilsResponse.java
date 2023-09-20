package com.bassure.ims.productservice.config;

import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;

import java.util.Map;

public class UtilsResponse {
    public static ResponseEntity responsesEntity(int code, Object value) {
        return ResponseEntity.builder().code(code).body(value).error(null).build();
    }

    public static ResponseEntity responsesEntity(int code, Map<String, String> error) {
        return ResponseEntity.builder().code(code).body(null).error(error).build();
    }
}
