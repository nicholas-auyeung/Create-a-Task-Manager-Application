package com.phase3end.exception;

public class UserNotFoundException extends RuntimeException{
	
	UserNotFoundException(Long uId){
		
		super("Could not find User " + uId);
	}
	

}
