package com.bathandbodyworks.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bathandbodyworks.entities.CustomerEntity;
import com.bathandbodyworks.entities.CustomerLoginEntity;

public class CustomerRepository {
	private SessionFactory sessionFactory;

	public void save(CustomerEntity customer) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}

	public void save(CustomerLoginEntity login) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(login);
		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
