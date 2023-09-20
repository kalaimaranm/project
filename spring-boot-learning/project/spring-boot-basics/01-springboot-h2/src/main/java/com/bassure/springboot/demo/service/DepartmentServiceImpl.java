package com.bassure.springboot.demo.service;

import com.bassure.springboot.demo.exception.DepartmentNotFoundException;
import com.bassure.springboot.demo.model.Department;
import com.bassure.springboot.demo.repository.DepartmentRespository;
import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRespository departmentRespository;

    @Override
    public Optional<Department> getDepartment(long id) {

        Optional<Department> result = departmentRespository.findById(id);

        if (result.isEmpty()) {
            throw new DepartmentNotFoundException("department not found id - " + id);
        }

        return result;
    }

    @Override
    public List<Department> getAllepartment() {

        return departmentRespository.findAll();
    }

    @Override
    public boolean deleteDepartment(Long id) {

        departmentRespository.deleteById(id);
        return true;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {

        department.setId(id);
        return departmentRespository.save(department);
    }

    @Override
    public Department getDepartmentByName(String name) {

        return departmentRespository.findByName(name);

    }

    @Override
    public int getDepartmentCount() {

        return departmentRespository.countOfDepartment();
    }
}
