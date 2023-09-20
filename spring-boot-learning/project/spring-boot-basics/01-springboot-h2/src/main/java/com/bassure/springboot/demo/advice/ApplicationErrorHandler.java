package com.bassure.springboot.demo.advice;

import com.bassure.springboot.demo.exception.DepartmentNotFoundException;
import com.bassure.springboot.demo.model.Department;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationErrorHandler {
    
    
//    List<Department> departments = new ArrayList();
//    
//    {
//        departments.stream().filter(department -> department.getId() == 10).findFirst().get();
//    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundHandler(DepartmentNotFoundException ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);

    }
}
