/**
 * 
 */
package com.mintree.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.book.store.BookStoreSystemClient;
import com.mindtree.exceptions.DBException;
import com.mindtree.exceptions.InvalidBookIdException;
import com.mindtree.exceptions.InvalidMobileNumberException;

/**
 * @author neelakanta
 *
 */
public class ManagerTest {

	/**
	 * Junit Test Class
	 * 
	 */

	public ManagerTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testDisplayBooks() throws DBException {
		boolean gotbookList = BookStoreSystemClient.printBookDetails("Technology");
		assertTrue(gotbookList == true);
	}

	@Test
	public void testDisplayBooksInvalidCategory() throws DBException {
		boolean gotbookList = BookStoreSystemClient.printBookDetails("Management");
		assertTrue(gotbookList == false);
	}

    @Test
	public void testPurchaseBook() {
		int purchseSavedFlag = BookStoreSystemClient.purchaseBook(1001, "Raj", "9900972900");
		assertEquals(1, purchseSavedFlag);
	}

    @Test
	public void testPurchaseBookInvalidBookId() {
		int purchseSavedFlag = BookStoreSystemClient.purchaseBook(1009, "Raj", "9900972900");

		if (purchseSavedFlag == 0) {
			try {
				throw new InvalidBookIdException("Invalid book id, please check your input");
			} catch (InvalidBookIdException e) {
			}
		} else {
			assertEquals(0, purchseSavedFlag);
		}
	}

    @Test
	public void testPurchaseBookInvalidMobileNo() {
		int purchseSavedFlag = BookStoreSystemClient.purchaseBook(1001, "Raj", "9900972");
		if (purchseSavedFlag == 0) {
			try {
				throw new InvalidMobileNumberException("Invalid book id, please check your input");
			} catch (InvalidMobileNumberException e) {
			}
		} else {
			assertEquals(0, purchseSavedFlag);
		}
	}
}
