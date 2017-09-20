/**
 * 
 */
package com.book.store.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.book.store.dao.BookStoreDAO;
import com.book.store.dao.DBTransaction;
import com.book.store.entity.Book;
import com.book.store.entity.Purchase;
import com.mindtree.exceptions.DBException;

/**
 * @author neelakanta
 *
 */
@SuppressWarnings("unchecked")
public class BookStoreDAOImpl implements BookStoreDAO{

	/**
	 * Data persisting and retrieving layer regarding books and purchases
	 */

	public BookStoreDAOImpl() {
		// TODO Auto-generated constructor stub
	}


	public List<Book> getBookList(String category) {
		List<Book> bookList = new ArrayList<Book>();
		Session session = null;
		try {
			SessionFactory sessionfactory = DBTransaction.createSessionFactory();
			session = sessionfactory.openSession();
			Query query = session.createQuery("from Book where Category = :category");
			query.setParameter("category", category);
			bookList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bookList;
	}
	
	public List<Integer> getBookIdList() {
		List<Integer> bookIdList = new ArrayList<Integer>();
		Session session = null;
		try {
			SessionFactory sessionfactory = DBTransaction.createSessionFactory();
			session = sessionfactory.openSession();
			Query query = session.createQuery("select bookId from Book");
			bookIdList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			session.close();
		}
		return bookIdList;
	}

	public List<String> getCategories() {
		List<String> bookCategories = new ArrayList<String>();
		Session session = null;
		try {
			SessionFactory sessionfactory = DBTransaction.createSessionFactory();
			session = sessionfactory.openSession();
			bookCategories = session.createQuery("select distinct categoryName from Book").list();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			session.close();
		}
		return bookCategories;
	}

	public boolean saveBookDetails(List<Book> bookList){
		boolean isSaved = false;
		Session session = null;
		Transaction tx = null;
		SessionFactory sessionfactory = null;
		try {
			Long bookCount = (long) 0;
			
			try {
				sessionfactory = DBTransaction.createSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session = sessionfactory.openSession();
			bookCount = (Long) session.createCriteria("com.book.store.entity.Book")
					.setProjection(Projections.rowCount()).uniqueResult();
			if (bookCount != null && bookCount > 0) {
				isSaved = true;
				return isSaved;
			} else {
				tx = session.beginTransaction();
				for (Book book : bookList) {
					session.save(book);
				}
				tx.commit();
				isSaved = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSaved;
	}

	public List<Purchase> savePurchase(int bookId, String customerName, String customerMobileNumber) {
		List<Purchase> purchased = new ArrayList<Purchase>();
		List<Book> book;
		Session session = null;
		Transaction tx = null;
		try {
			SessionFactory sessionfactory = DBTransaction.createSessionFactory();
			session = sessionfactory.openSession();
			Query query = session.createQuery("from Book where bookId = :bookId");
			query.setParameter("bookId",bookId);
			book = query.list();
			
			Purchase newPurchase = new Purchase();
			newPurchase.setBookId(bookId);
			newPurchase.setCustomerName(customerName);
			newPurchase.setCustomerMobileNumber(customerMobileNumber);
			newPurchase.setPurchaseDate(new Date().toString());
			newPurchase.setAmount(book.get(0).getPrice());
			tx = session.beginTransaction();
			session.save(newPurchase);
			tx.commit();
			
			query = session.createQuery("from Purchase where customerName = :customerName");
			query.setParameter("customerName",customerName);
			purchased = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return purchased;
	}
}
