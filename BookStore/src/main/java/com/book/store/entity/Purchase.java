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
@Table(name="Purchase")
public class Purchase {

	/**
	 * This is an Entity class that encapsulate details regarding the purchase
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Purchase_no")
	private int purchaseNumber;
	@Column(name = "Book_id")
	private int bookId;
	@Column(name = "Customer_name")
	private String customerName;
	@Column(name = "Customer_mobileno")
	private String customerMobileNumber;
	@Column(name = "Purchase_date")
	private String purchaseDate;
	@Column(name = "Amount")
	private int amount;
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Purchase [getPurchaseNumber()=" + getPurchaseNumber() + ", getBookId()=" + getBookId()
				+ ", getCustomerName()=" + getCustomerName() + ", getCustomerMobileNumber()="
				+ getCustomerMobileNumber() + ", getPurchaseDate()=" + getPurchaseDate() + ", getAmount()="
				+ getAmount() + "]";
	}
	
}
