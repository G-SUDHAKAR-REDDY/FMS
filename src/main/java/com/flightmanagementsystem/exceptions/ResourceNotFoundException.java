package com.flightmanagementsystem.exceptions;

public class ResourceNotFoundException extends Exception {  //compile time exception 

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
