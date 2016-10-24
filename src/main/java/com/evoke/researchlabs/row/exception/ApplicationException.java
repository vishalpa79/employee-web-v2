package com.evoke.researchlabs.row.exception;

/**
 * Its a custom exception class for throwing user defined exception
 * @author apandiri
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -7572491642642059540L;
	private String message = null;

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
