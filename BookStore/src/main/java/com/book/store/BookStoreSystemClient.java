/**
 * 
 */
package com.book.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.book.store.entity.Book;
import com.book.store.entity.Purchase;
import com.book.store.service.BookStoreService;
import com.book.store.service.Service;
import com.mindtree.exceptions.DBException;
import com.mindtree.exceptions.InvalidBookIdException;
import com.mindtree.exceptions.InvalidCategoryException;
import com.mindtree.exceptions.InvalidMobileNumberException;
import com.mindtree.exceptions.InvalidPurchaseException;

/**
 * @author neelakanta
 *
 */
public class BookStoreSystemClient {

	/**
	 * 
	 */

	static Scanner sc = new Scanner(System.in);

	public BookStoreSystemClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		populateBooks();

		System.out.println("Welcome to our BookStore !!!!");
		System.out.println("Please choose from the following options....");
		int action = 0;

		while (action != 3) {
			System.out.println("*************************************************");
			System.out.println("1. Display book details");
			System.out.println("2. Purchase a book");
			System.out.println("3. Exit");
			System.out.println("*************************************************");
			try {
				action = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter correct option ...");
			}

			performAction(action);
		}

		sc.close();
	}

	//This is the action method like view book details or to purchase book based on consumer's input
	public static void performAction(int action) throws DBException {
		if (action == 1) {
			
			List<String> categoryList = Collections.emptyList();
			Service bookStoreService = new BookStoreService();
			categoryList = bookStoreService.getCategories();
			System.out.println("Enter the category " + categoryList);
			String getCategory = sc.nextLine();
			printBookDetails(getCategory);
			
		} else if (action == 2) {
			
			System.out.print("Enter bookId                 : ");
			int bookId = Integer.parseInt(sc.nextLine());
			System.out.print("Enter Customer Name          :");
			String customerName = sc.nextLine();
			System.out.print("Enter Customer Mobile Number :");
			String customerMobileNumber = sc.nextLine();
			purchaseBook(bookId, customerName, customerMobileNumber);
		} else if (action == 3) {
			
			System.out.println("Thank You !!!!");
			System.out.println("Visit Again :)");
			System.exit(0);
			
		} else {
			System.out.println("Please enter valid option ... ");
		}
	}

	//This method is used to collect user's data and save the purchase details
	public static int purchaseBook(int bookId, String customerName, String customerMobileNumber) {
		int purchseSavedFlag = 0;
		Purchase purchasedBook = null;
		Service bookStoreService = new BookStoreService();
		try {
			List<Integer> bookIdList = bookStoreService.getBookIdList();
			if (!bookIdList.contains(bookId))
				throw new InvalidBookIdException("Invalid book id, please check your input");
			if (customerMobileNumber.length() != 10 || !customerMobileNumber.matches("[0-9]+"))
				throw new InvalidMobileNumberException("Invalid mobile no, please check your input");
			List<Purchase> isPurchasedSaved = bookStoreService.savePurchase(bookId, customerName, customerMobileNumber);
			purchasedBook = new Purchase();
			for (Purchase purchased : isPurchasedSaved) {
				if (purchased.getBookId() == bookId) {
					purchseSavedFlag = 1;
					purchasedBook = purchased;
				}
			}
			if (purchseSavedFlag == 1) {
				System.out.println("Book successfully purchased !");
				System.out.println("Purchase Number : " + purchseSavedFlag);
				System.out.println("Purchase Date   : " + purchasedBook.getPurchaseDate());
				System.out.println("Purchase Amount : " + purchasedBook.getAmount());
			} else {
				throw new InvalidPurchaseException("Error while purchasing this book. Please try after some time...");
			}
		} catch (InvalidBookIdException ex) {
			System.out.println(ex.toString());
		} catch (InvalidMobileNumberException | InvalidPurchaseException e) {
			System.out.println(e.toString());
		}
		return purchseSavedFlag;
	}

	//This method is used to print Book Details for the specific category
	public static boolean printBookDetails(String category) throws DBException {
		boolean gotBookList = false;
		Service bookStoreService = new BookStoreService();
		List<Book> bookList = bookStoreService.getBookList(category);
		try {
			if (bookList.size() > 0) {
				gotBookList = true;
				System.out.format("%-8s%-30s%-30s%-15s%-20s", "Id", "BookName", "Author", "Publisher", "Price");
				for (Book book : bookList) {
					System.out.println();
					System.out.format("%-8d%-30s%-30s%-15s%-20d", book.getBookId(), book.getBookName(),
							book.getAuthorName(), book.getPublisherName(), book.getPrice());
				}
			} else {
				throw new InvalidCategoryException("Invalid category name please check your input");
			}
		} catch (InvalidCategoryException e) {
			System.out.println(e.toString());
		}
		System.out.println(String.format("%n"));
		return gotBookList;
	}

	//This method is used to populate the Book Details if not there
	public static void populateBooks() {
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book(1001, "Java: The Complete Reference", "Herbert Schildt", "Tata", "Technology", 615));
		bookList.add(new Book(1002, "Matlab Programming", "Singh Y. Kirani", "Subhash", "Technology", 232));
		bookList.add(new Book(1003, "Half Girlfriend", "Chetan Bhagat", "Tata", "General", 95));
		bookList.add(new Book(1004, "Forge your Future", "A.P.J. Abdul Kalam", "Swapna", "General", 200));
		bookList.add(new Book(1005, "The Fault in our Stars", "John Green", "Pai", "Kids", 159));
		bookList.add(new Book(1006, "My Little Book", "Randall Munroe", "Pai", "Kids", 420));
		boolean isSaved = false;
		try {
			Service bookStoreService = new BookStoreService();
			isSaved = bookStoreService.saveBookList(bookList);
			if (isSaved == true) {

			} else {
				System.out.println("Not able to populate Book Details :(");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while populating Book Details :(");
			System.exit(1);
		}
	}

}
