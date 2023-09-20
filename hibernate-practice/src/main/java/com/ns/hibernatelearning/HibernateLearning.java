package com.ns.hibernatelearning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class HibernateLearning {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_l");
        EntityManager em = emf.createEntityManager();
        Hmember temp = new Hmember(1003, "kalai", "7397142732");

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Hmember member = em.find(Hmember.class, 1l);
        em.getTransaction().commit();
        em.close();
        
        System.out.println("member details: "+member);
        System.out.println(member.getContacts());
                
//        tx.begin();
//       
//        em.persist(temp);
//        
//        tx.commit();
//        em.close();
//        emf.close();
    }

    public static void main2(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_l");
        EntityManager em = emf.createEntityManager();

        List<Hmember> allmember = em.createQuery("select m from Hmember m").getResultList();

        for (Hmember n : allmember) {
            System.out.println(n);
        }

        em.close();
        emf.close();
    }

    public static void main3(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_l");
        EntityManager em = emf.createEntityManager();

        Hmember temp = em.find(Hmember.class, 1002L);
//            System.out.println(temp);
        em.getTransaction().begin();
        em.remove(temp);
        em.getTransaction().commit();

        main2(null);
        em.close();
        emf.close();
    }

    public static void main4(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_l");
        EntityManager em = emf.createEntityManager();

        String name = em.createQuery("select m.name from Hmember m where m.mobile=?1 ", String.class)
                .setParameter(1, "9443473331").getSingleResult();

        System.out.println(name);
        em.close();
        emf.close();

    }

    public static void main1(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_l");
        EntityManager em = emf.createEntityManager();

        List<String> temp = em.createQuery("select m.name from Hmember m where m.mobile=?1", String.class)
                .setParameter(1, "7397142731").getResultList();

        for (String hmember : temp) {
            System.out.println(hmember);
        }

        em.close();
        emf.close();

    }

}
