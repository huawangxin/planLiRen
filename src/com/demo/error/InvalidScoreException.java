package com.demo.error;

public class InvalidScoreException extends Exception {

	/**
	 * ΨһID
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidScoreException() {
		super();
	}
	public InvalidScoreException(String meg){
		super(meg);
	}
}
