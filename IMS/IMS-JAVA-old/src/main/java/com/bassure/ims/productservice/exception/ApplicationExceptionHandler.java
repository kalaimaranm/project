package com.bassure.ims.productservice.exception;

import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.response.ResponseBody;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.bassure.ims.productservice.response.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @Autowired
    private HttpStatusCode httpStatusCodeConfig;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(httpStatusCodeConfig.getError()).build())
                .body(ResponseBody.builder().error(errors).build())
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity handleNullPointer(NullPointerException exception) {
        Map<String, String> errors = new HashMap<>();
        return ResponseEntity.builder()
                .header(ResponseHeader.builder().code(httpStatusCodeConfig.getError()).build())
                .body(ResponseBody.builder().error(errors).build())
                .build();
    }
}
