package com.training.springbootjpa.exceptions;

public class NoSuchAccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoSuchAccountException(String message) {
		super(message);
	}
}
