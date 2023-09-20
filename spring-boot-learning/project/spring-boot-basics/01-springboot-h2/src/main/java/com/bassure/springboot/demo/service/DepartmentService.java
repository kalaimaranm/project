package com.bassure.springboot.demo.service;

import com.bassure.springboot.demo.model.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public Optional<Department> getDepartment(long id);

    public List<Department> getAllepartment();

    public boolean deleteDepartment(Long id);

    public Department addDepartment(Department department);
    
    public Department updateDepartment(Long id, Department department);
    
    public int getDepartmentCount();
    
    public Department getDepartmentByName(String name);
}
