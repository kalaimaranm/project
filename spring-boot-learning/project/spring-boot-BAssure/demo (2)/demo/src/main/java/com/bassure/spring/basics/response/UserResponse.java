package com.bassure.spring.basics.response;

import java.util.Map;

public class UserResponse<T> {

    private int status;
    private Map<String, String> errors;
    private String message;
    private T data;
  
    

    public UserResponse() {}

    public UserResponse(int status, Map<String, String> errors, String message, T data) {
        this.status = status;
        this.errors = errors;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserResponse{" + "status=" + status + ", errors=" + errors + ", message=" + message + ", data=" + data + '}';
    }

}
