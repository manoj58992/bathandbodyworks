package com.bathandbodyworks.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bathandbodyworks.entities.CustomerEntity;

public class CustomerLoginRepository {

	private SessionFactory sessionFactory;

	public CustomerEntity getByname(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query q = session.createQuery("select c from CustomerEntity c where c.name =:userid");
		q.setParameter("userid", name);

		CustomerEntity c = (CustomerEntity) q.uniqueResult();
		session.getTransaction().commit();
		session.close();

		return c;
	}

}
