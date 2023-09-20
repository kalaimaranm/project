package com.bassure.springboot.demo.repository;

import com.bassure.springboot.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {

    public Department findByName(String name);
    
    
    @Query(value = "SELECT COUNT(*) FROM department",nativeQuery = true)
    public int countOfDepartment();
    
    

}
