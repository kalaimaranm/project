package com.kalai.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kalai.hibernate.crud.CrudOperation;
import com.kalai.hibernate.crud.CrudOperationImpl;
import com.kalai.hibernate.crud.HibernateUtil;
import com.kalai.hibernate.entity.Song;
import java.util.List;

public class App {

    public static void main2(String... args) {
        System.out.println("Hibernate Application");
//        App myApp = new App();  
        isolationChecking();
        Song song = new Song();
//		song.setId(100);
        song.setName("Beliver-2");
        song.setArtist("IMAGINE DRAGON");
        CrudOperation crudOperation = new CrudOperationImpl();
        crudOperation.insertData(song);
        // loading the configuration file

//         ("hibernate.cfg.xml"); // not need to write configure("hibernate.cfg.xml")
//         if your file name is hibernate.cfg.xml it automatically search here you can
//         use configure()
//		configuration.addAnnotatedClass(Song.class);
//         creating sessionFactory - heavy weight
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//         getting single session from sessionFactory
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(song);
//		session.getTransaction().commit();
//		session.close();// must
        System.out.println("song saved successfully....");
        Song song2 = crudOperation.getData(100);
        System.out.println(song2);
//		song2.setArtist("Imagine Dragon".toUpperCase());
//		crudOperation.updateData(song2);
//		System.out.println("song updated successfully....");

//		crudOperation.deleteData(song2);
        System.out.println("deleted successfully.......");

    }

    public static void isolationChecking() {

        Session session = HibernateUtil.getSession();
        Song song = new Song();
        song.setArtist("Santhosh Narayanan");
        song.setName("kadhal kappal");
        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();

    }

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Song song;
        try {
            song = (Song) session.createNativeQuery("select * from where id = 100", Song.class)
                    .getSingleResult();
            session.getTransaction().commit();
        } finally {
            session.close();

        }
        System.out.println(song);
//        songs.stream().forEach(song -> System.out.println(song));

    }

}
