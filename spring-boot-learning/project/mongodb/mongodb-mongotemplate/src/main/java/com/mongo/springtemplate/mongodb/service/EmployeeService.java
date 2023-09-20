package com.mongo.springtemplate.mongodb.service;

import com.mongo.springtemplate.mongodb.model.Employee;
import com.mongo.springtemplate.mongodb.repository.EmployeeRepository;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {

        return employeeRepository.getAllEmployee();
    }
    
    public List<Document> getAllEmployeeInDocument() {
        
        return employeeRepository.getAllEmployeeInDocument();
    }

    public Employee update(Employee employee) {

        return employeeRepository.update(employee);

    }

    public Employee getEmployee(String id) {

        
        return employeeRepository.getEmployee(id);

    }

    public List<Employee> findBySalary(int salary) {

      return employeeRepository.getEmployeeBySalary(salary);
    }

    public List<Employee> findByMatchingName(String name) {

        
        return employeeRepository.findByMatchingName(name);

    }

}
