/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author neelakanta
 *
 */
public class DBException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9100710029507076153L;

	/**
	 * 
	 */
	public DBException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DBException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DBException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DBException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
