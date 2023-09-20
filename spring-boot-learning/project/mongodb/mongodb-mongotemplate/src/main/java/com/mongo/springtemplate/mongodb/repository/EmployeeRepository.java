package com.mongo.springtemplate.mongodb.repository;

import com.mongo.springtemplate.mongodb.model.Employee;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Employee save(Employee employee) {

        return mongoTemplate.save(employee);

    }

    public List<Employee> getAllEmployee() {

        return mongoTemplate.findAll(Employee.class);
    }

    public List<Document> getAllEmployeeInDocument() {

        return mongoTemplate.findAll(Document.class, "employee");
    }

    public Employee update(Employee employee) {

        Query query = new Query(Criteria.where("_id").is(employee.getId()));
//        Document document = 
//        Update update = new BasicUpdate();
//        UpdateResult result = mongoTemplate.updateFirst(query, update, "employee");
        return mongoTemplate.save(employee);

    }

    public Employee getEmployee(String id) {

        return mongoTemplate.findById(id, Employee.class);

    }

    public List<Employee> getEmployeeBySalary(int salary) {

        Query query = new Query(Criteria.where("salary").is(salary));
        return mongoTemplate.find(query, Employee.class);

    }

    public List<Employee> findByMatchingName(String name) {

        Query query = new Query(Criteria.where("firstName").regex("^" + name));

        return mongoTemplate.find(query, Employee.class);

    }

    public long deleteEmployee(String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, "employee");
       return result.getDeletedCount();
    }

}
