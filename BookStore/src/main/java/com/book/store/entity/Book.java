/**
 * 
 */
package com.book.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author neelakanta
 *
 */
@Entity
@Table(name="Book")
public class Book {

	/**
	 * This is an Entity class that encapsulate details regarding the book
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Book_id")
	private int bookId;
	@Column(name = "Book_name")
	private String bookName;
	@Column(name = "Author_name")
	private String authorName;
	@Column(name = "Publisher")
	private String publisherName;
	@Column(name = "Category")
	private String categoryName;
	@Column(name = "price")
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bookId, String bookName, String authorName, String publisherName, String categoryName, int price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.categoryName = categoryName;
		this.price = price;
	}
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [getBookId()=" + getBookId() + ", getBookName()=" + getBookName() + ", getAuthorname()="
				+ getAuthorName() + ", getPublisherName()=" + getPublisherName() + ", getCategoryName()="
				+ getCategoryName() + ", getPrice()=" + getPrice() + "]";
	}
	
}
