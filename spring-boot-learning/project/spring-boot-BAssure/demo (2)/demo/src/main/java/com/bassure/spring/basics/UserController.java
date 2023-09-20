package com.bassure.spring.basics;

import com.bassure.spring.basics.entity.Employee;
import com.bassure.spring.basics.response.UserResponse;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class UserController {

    @GetMapping("/all-secured")
    public String getUser() {

        return "springBootHome";

    }

    @GetMapping("/admin")
    public String getAdmin() {

        return "admin/home";
    }

    @GetMapping("/common")
    public String getCommon() {

        return "springBootHome";
    }

    @GetMapping("/get-form")
    public String getForm() {

        return "form";
    }

//    @GetMapping("/submit-form")
//    public String submitForm(WebRequest request) {
//
////        Employee employee = new RestTemplate().getForObject(URI.create("http://localhost:8081/"), request.);
//        return "form-success";
//
//    }

    @PostMapping("/employees")
    public ResponseEntity<UserResponse> addEmployee(@Valid @RequestBody Employee employee, BindingResult error) {

        if (error.hasErrors()) {
            Map<String, String> errors = new HashMap();
            error.getAllErrors().forEach(e -> {
                errors.put(((FieldError) e).getField(), e.getDefaultMessage());
            });

            return ResponseEntity
                    .status(HttpStatusCode.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
                    .body(new UserResponse(425, errors, "not added successfully", employee));

        }

        return ResponseEntity.ok(new UserResponse(200, null, "new User added successfully", employee));

    }

}
