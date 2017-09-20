/**
 * 
 */
package com.book.store.dao;

import java.util.List;

import com.book.store.entity.Book;
import com.book.store.entity.Purchase;
import com.mindtree.exceptions.DBException;

/**
 * @author neelakanta
 *
 */
public interface BookStoreDAO {

	public List<Book> getBookList(String category);

	public List<Integer> getBookIdList();

	public List<String> getCategories();

	public boolean saveBookDetails(List<Book> bookList);

	public List<Purchase> savePurchase(int bookId, String customerName, String customerMobileNumber);

}
