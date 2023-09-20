package com.bassure.springboot.demo.controller;

import com.bassure.springboot.demo.model.Department;
import com.bassure.springboot.demo.service.DepartmentService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentServiceImpl;
    
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    
    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartment(@PathVariable long id) {
        System.out.println("id : " + id);
        
        return departmentServiceImpl.getDepartment(id);
    }
    
    @PostMapping("/departments")
    public Department addDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("----------- inside addDepartment() function -----------");
        
        System.out.println("Department : " + department);
        return departmentServiceImpl.addDepartment(department);
    }
    
    @GetMapping("/departments")
    public List<Department> getAllDepartment() {
        LOGGER.info("------------- inside getAlldepartment() function ----------");
        
        return departmentServiceImpl.getAllepartment();
    }
    
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        LOGGER.info("------------- inside deleteDepartment() function -----------");
        
        departmentServiceImpl.deleteDepartment(id);
        
        return "Department deleted Successfully - " + id;
        
    }
    
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,
            @RequestBody Department department) {
        
        return departmentServiceImpl.updateDepartment(id, department);
        
    }
    
    @GetMapping("/checking")
    public String checking() {
        
        return "Welcome to spring-boot project";
    }
    
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        
        return departmentServiceImpl.getDepartmentByName(name);
    }
    
    @GetMapping("/departments/count")
    public String getDepartmentCount() {
        
        return "Your department count is - " + departmentServiceImpl.getDepartmentCount();
        
    }
    
}
