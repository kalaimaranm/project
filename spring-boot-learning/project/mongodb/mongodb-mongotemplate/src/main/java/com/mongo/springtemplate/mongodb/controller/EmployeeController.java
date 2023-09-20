package com.mongo.springtemplate.mongodb.controller;

import com.mongo.springtemplate.mongodb.model.Employee;
import com.mongo.springtemplate.mongodb.service.EmployeeService;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/employees")
//    public Employee saveEmployee(@RequestBody Employee employee) {
//
//        return employeeService.save(employee);
//    }

//    @GetMapping("/employees")
//    public List<Employee> getAllEmployee() {
//
//        return employeeService.getAllEmployee();
//    }
//    @GetMapping("/employees/document")
//    public List<Document> getAllEmployeeInDocument() {
//
//        return employeeService.getAllEmployeeInDocument();
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//
//        return employeeService.update(employee);
//    }
//
//    @GetMapping("/employees/{id}")
//    public Employee getEmployee(@PathVariable String id) {
//
//        return employeeService.getEmployee(id);
//    }
//
//    @GetMapping("/employees/salary")
//    public List<Employee> findBySalary(@RequestParam int salary) {
//
//        return employeeService.findBySalary(salary);
//    }
//
//    @GetMapping("/employees/name")
//    public List<Employee> findByMathcingName(@RequestParam String name) {
//
//        return employeeService.findByMatchingName(name);
//    }

}
