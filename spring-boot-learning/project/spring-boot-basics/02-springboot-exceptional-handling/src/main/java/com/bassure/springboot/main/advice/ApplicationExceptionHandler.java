package com.bassure.springboot.main.advice;

import com.bassure.springboot.main.exception.UserNotFoundException;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap();

        ex.getBindingResult().getFieldErrors().forEach(error -> {

            System.out.println("Error Field : " + error.getField() + "\nError message : " + error.getDefaultMessage());

            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return errorMap;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> userNotFoundHandler(UserNotFoundException ex) {

        Map<String, String> errorMessage = new HashMap();

        errorMessage.put("user not found", ex.getMessage());

        return errorMessage;
    }
}
