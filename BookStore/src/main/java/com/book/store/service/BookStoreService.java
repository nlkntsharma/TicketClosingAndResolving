/**
 * 
 */
package com.book.store.service;

import java.util.Collections;
import java.util.List;

import com.book.store.dao.BookStoreDAO;
import com.book.store.dao.impl.BookStoreDAOImpl;
import com.book.store.entity.Book;
import com.book.store.entity.Purchase;

/**
 * @author neelakanta
 *
 */
public class BookStoreService implements Service {

	/**
	 * 
	 */
	public BookStoreService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book> getBookList(String category){
		List<Book> bookList = Collections.emptyList();
		BookStoreDAO bookStoreDao = new BookStoreDAOImpl();
		try {
			bookList = bookStoreDao.getBookList(category);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<String> getCategories(){
		List<String> bookCategories = Collections.emptyList();
		BookStoreDAO bookStoreDao = new BookStoreDAOImpl();
		try {
			bookCategories = bookStoreDao.getCategories();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookCategories;
	}

	@Override
	public boolean saveBookList(List<Book> bookList) {
		boolean isSaved = false;
		BookStoreDAO bookStoreDao = new BookStoreDAOImpl();
		try {
			isSaved = bookStoreDao.saveBookDetails(bookList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}

	@Override
	public List<Purchase> savePurchase(int bookId, String customerName, String customerMobileNumber){
		List<Purchase> isPurchaseSaved = Collections.emptyList();
		BookStoreDAO bookStoreDao = new BookStoreDAOImpl();
		try {
			isPurchaseSaved = bookStoreDao.savePurchase(bookId, customerName, customerMobileNumber);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isPurchaseSaved;
	}

	@Override
	public List<Integer> getBookIdList() {
		List<Integer> bookIdList = Collections.emptyList();
		BookStoreDAO bookStoreDao = new BookStoreDAOImpl();
		try {
			bookIdList = bookStoreDao.getBookIdList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookIdList;
	}

}
