package com.codex.exception;

/** User Defined/Custom Exception class **/
public class NoDataFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String msg) {
		super(msg);        // call super class Constructor i.e. RuntimeException(String message)
	}

}
