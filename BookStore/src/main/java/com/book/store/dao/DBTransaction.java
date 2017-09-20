/**
 * 
 */
package com.book.store.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.exceptions.DBException;

/**
 * @author neelakanta
 *
 */
public class DBTransaction {

	/**
	 *  This class is to create session factory
	 */

	public DBTransaction() {

	}

	public static SessionFactory createSessionFactory() throws Exception{
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;

	}
}
