package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    public EmployeeRestController(EmployeeServiceImpl theEmployeeService) {

        this.employeeService = theEmployeeService;
    }

    public EmployeeRestController() {

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee find(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            System.out.println("employee null");
//            throw new RuntimeException("employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        System.out.println(theEmployee);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {

            throw new EmployeeNotFoundException("employee id not found - " + employeeId);
        }

        employeeService.deleteEmployee(employee);

        return "employee deleted successfully id - " + employeeId;
    }

    public ResponseEntity<EmployeeErrorResponse> errorHandle(EmployeeNotFoundException emp) {

        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setMessage(emp.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}
