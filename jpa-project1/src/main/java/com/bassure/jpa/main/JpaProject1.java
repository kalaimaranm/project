package com.bassure.jpa.main;

import com.bassure.jpa.entities.Student;
import jakarta.persistence.Persistence;

public class JpaProject1 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("hibernate_l");
        var em = emf.createEntityManager();

//        Product product = new Product();
//        prod  uct.setId(6);
//        product.setName("Dummy-2");
//        product.setPrice(149.00);
//        em.getTransaction().begin();
//        em.persist(product);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        Event event = new Event();
//        event.setDescription("Working Good...");
//        em.getTransaction().begin();
//        em.persist(event);
//        em.getTransaction().commit();
//        em.close();
//        Seller seller = new Seller();
//        seller.setName("Cloud-Tail-Hypen");
//        em.getTransaction().begin();
//        em.persist(seller);
//        em.getTransaction().commit();
//        em.close();
//        Price price = new Price();
//        price.setAmount(10.00);
//        price.setCurrency(Currency.YEN);
//        em.getTransaction().begin();
//        em.persist(price);
//        em.getTransaction().commit();
//        em.close();
//        Employee employee = new Employee();
//        employee.setName("Dinish");
//        employee.setDate(new Date());
//        employee.setAddress(new Address());
//        employee.getAddress().setArea("K.K.Nagar");
//        employee.getAddress().setStr("street");
//        employee.getAddress().setDis("Chennai");
//        em.getTransaction().begin();
//        em.persist(employee);
//        em.getTransaction().commit();
//        em.close();
//        Course course = new Course();
//        course.setId(new CoursePK());
//        course.getId().setId(101);
//        course.getId().setCandidateId(201);
//        course.setName("Ambi");
//
//        em.getTransaction().begin();
//        em.persist(course);
//        em.getTransaction().commit();
//        em.close();
        Student student = new Student();
        student.setAge(19);
//        student.setId(1001);
        student.setName("Asif");
        student.setCourseName("Urudu-Begginer to Expert");

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();

    }

}
