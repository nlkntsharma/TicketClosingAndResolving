/**
 * 
 */
package com.book.store.service;

import java.util.List;

import com.book.store.entity.Book;
import com.book.store.entity.Purchase;
import com.mindtree.exceptions.DBException;

/**
 * @author neelakanta
 *
 */
public interface Service {
	public List<Book> getBookList(String category);
	public List<Integer> getBookIdList();
	public List<String> getCategories();
	public boolean saveBookList(List<Book> bookList);
	public List<Purchase> savePurchase(int bookId, String customerName,String customerMobileNumber);
}
