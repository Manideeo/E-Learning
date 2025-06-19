package com.example.ecomm.exception;

public class IdNotFoundException extends Exception {
	
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return "Id not found";
	}
	
	

}
