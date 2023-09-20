package com.bassure.ims.productservice.exception;

import com.bassure.ims.productservice.config.HttpStatusCode;
import com.bassure.ims.productservice.config.HttpStatusMessage;
import com.bassure.ims.productservice.config.UtilsResponse;
import com.bassure.ims.productservice.response.ResponseEntity;
import com.mongodb.MongoException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @Autowired
    private HttpStatusCode status;

    @Autowired
    private HttpStatusMessage message;

    private Map<String, String> errors = new HashMap<>();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return UtilsResponse.responsesEntity(status.getError(), errors);
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity handleNullPointer(NullPointerException exception) {
//        Map<String, String> errors = new HashMap<>();
        return UtilsResponse.responsesEntity(status.getError(), errors);
    }

    @ExceptionHandler(TypeMismatchException.class)
    private ResponseEntity handleTypeMismatchException(TypeMismatchException exception) {

        return UtilsResponse.responsesEntity(status.getError(), message.getFailed());
    }

    @ExceptionHandler(MongoException.class)
    private ResponseEntity handleMongoException(MongoException exception) {

//        Map<String, String> errors = new HashMap<>();
        return UtilsResponse.responsesEntity(status.getError(), message.getServerError());
    }

}
