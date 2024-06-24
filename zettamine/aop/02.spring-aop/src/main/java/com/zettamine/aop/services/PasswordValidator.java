package com.zettamine.aop.services;

public class PasswordValidator {
	
  public boolean validatePassword(String pass) {
	  int length = pass.trim().length();
	  
	  if(length >= 5)
		  return true;
	  else {
		  throw new RuntimeException("password should be >= 5 length");
		  //return false;
	  }
  }
}
