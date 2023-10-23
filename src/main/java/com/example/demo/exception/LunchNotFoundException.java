package com.example.demo.exception;

public class LunchNotFoundException extends RuntimeException{

	public LunchNotFoundException(Long id){
		super("Could not find lunch code " + id);
	}
	
}
