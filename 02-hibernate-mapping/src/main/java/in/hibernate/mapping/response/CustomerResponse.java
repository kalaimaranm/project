package in.hibernate.mapping.response;

import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Component
//@Scope(value = "prototype")
public class CustomerResponse<T> {

    private int statusCode;
    private String message;
    private Map<String, String> errors;
    private T t;

    public CustomerResponse() {}
    
    public CustomerResponse(int statusCode, String message, Map<String, String> errors, T t) {
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
        this.t = t;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" + "statusCode=" + statusCode + ", message=" + message + ", errors=" + errors + ", t=" + t + '}';
    }
    
    

}
