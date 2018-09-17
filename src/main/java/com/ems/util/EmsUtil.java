package com.ems.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmsUtil {

	private SessionFactory hibernateFactory;

	@Autowired
	public EmsUtil(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
	}

	public SessionFactory getHibernateFactory() {
		return hibernateFactory;
	}

	public void setHibernateFactory(SessionFactory hibernateFactory) {
		this.hibernateFactory = hibernateFactory;
	}

}
