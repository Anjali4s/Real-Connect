package com.real_connect.exception;

public class PropertyNotFoundException extends RuntimeException{
	
//	public PropertyNotFoundException() {
//		super("Property not found on server!!");
//	}
	public PropertyNotFoundException(String message) {
		super(message);
	}

}
