package com.bassure.jpa.main;

import com.bassure.jpa.entities.Detail;
import com.bassure.jpa.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class JpaProject2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-one");
        EntityManager em = emf.createEntityManager();

        Product product = new Product();
        product.setName("RedBull");
        product.setPrice(149.00);

        Detail detail = new Detail();
        detail.setExpirationDate(new Date());
        detail.setJ_product(product);

        em.getTransaction().begin();
        em.persist(detail);
        em.getTransaction().commit();
        em.close();

    }
}
