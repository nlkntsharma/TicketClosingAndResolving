/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author neelakanta
 *
 */
public class SessionCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5284363846042684392L;

	/**
	 * 
	 */
	public SessionCreationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SessionCreationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SessionCreationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SessionCreationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SessionCreationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
