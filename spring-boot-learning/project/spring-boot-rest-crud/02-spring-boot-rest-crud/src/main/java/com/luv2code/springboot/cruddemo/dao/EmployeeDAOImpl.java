package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    public EmployeeDAOImpl() {

    }

    public EmployeeDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> employees = entityManager.createQuery("from Employee", Employee.class);

        return employees.getResultList();

    }

    @Override
    public Employee findById(int theId) {

        return entityManager.find(Employee.class, theId);

    }

    @Override
    public Employee save(Employee theEmployee) {

        System.out.println("inside merge");
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteEmployee(Employee theEmployee) {

        entityManager.remove(theEmployee);
    }

}
