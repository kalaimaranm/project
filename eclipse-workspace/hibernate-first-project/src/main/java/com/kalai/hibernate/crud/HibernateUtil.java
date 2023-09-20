package com.kalai.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kalai.hibernate.entity.Song;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {

    }

    public static Session getSession() {

        return getSessionFactory().openSession();
    }

    public static SessionFactory getSessionFactory() {
// use try catch because properties value can be wrong so it throw expection
        // singleton design
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure();

                configuration.addAnnotatedClass(Song.class);
                sessionFactory = configuration.buildSessionFactory();

                return sessionFactory;
            } else {
                return sessionFactory;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("session factory not created....");
        }

        return null;
    }

}
