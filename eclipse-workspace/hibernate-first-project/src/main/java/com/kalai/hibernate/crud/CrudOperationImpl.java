package com.kalai.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kalai.hibernate.entity.Song;

public class CrudOperationImpl implements CrudOperation {

	public boolean insertData(Song song) {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(song);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public Song getData(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		Song song = session.get(Song.class, id); //
//		session.getTransaction().commit();
//		session.close();
		return song;
	}

	public boolean updateData(Song song) {

		Session session = HibernateUtil.getSession();
		Song song1 = session.get(Song.class, song.getId());
		session.beginTransaction();
		session.update(song1);
		session.getTransaction().commit();
		session.close();
		return true;

	}

	public boolean deleteData(Song song) {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(song);
		session.getTransaction().commit();
		session.close();

		return true;
	}

}
