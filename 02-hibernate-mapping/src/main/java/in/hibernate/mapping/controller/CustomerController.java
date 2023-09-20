package in.hibernate.mapping.controller;

import in.hibernate.mapping.entity.Customer;
import in.hibernate.mapping.response.CustomerResponse;
import in.hibernate.mapping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
    
//    @Autowired
    private CustomerResponse<Customer> response = new CustomerResponse();
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable() Long id) {
        
        
        response.setErrors(null);
        response.setMessage("customer detail");
        response.setStatusCode(200);
        response.setT(customerService.getCustomer(id));
        
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody Customer customer) {
        
        
        
        response.setErrors(null);
        response.setMessage("customer added successfully");
        response.setStatusCode(200);
        response.setT(customerService.addCustomer(customer));
        
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable Long id) {
        
        
        
        response.setErrors(null);
        response.setMessage("customer deleted successfully");
        response.setStatusCode(200);
        response.setT(null);
        return ResponseEntity.ok().body(response);
    }
    
}
