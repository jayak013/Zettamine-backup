package com.zettamine.aop.services;

public class PasswordValidator {
	
	  public boolean validatePassword(String pass) {
		  System.out.println("\033[32mlogic to validate password \033[0m");
		  int length = pass.trim().length();
		  if(length >= 5)
			  return true;
		  else {
			  throw new RuntimeException("password should be >= 5 length");
			  //return false;
		  }
	  }
	
}
