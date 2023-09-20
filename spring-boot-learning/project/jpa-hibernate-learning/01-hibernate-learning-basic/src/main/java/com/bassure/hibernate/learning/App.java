package com.bassure.hibernate.learning;

import com.bassure.hibernate.entity.Person;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {

    public static void main(String... args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(new Person("kalaimaran", "madhavan", LocalDateTime.now()));
        transaction.commit();
        em.close();
    }
}
