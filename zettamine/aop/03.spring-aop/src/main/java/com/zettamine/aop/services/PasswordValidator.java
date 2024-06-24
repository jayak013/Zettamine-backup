package com.zettamine.aop.services;

public class PasswordValidator {
  public boolean validatePassword(String pass) {
	  System.out.println("validation password....");
	  try {
		 Thread.sleep(3000); 
	  }catch(Exception ex) {}
	  
	  int length = pass.trim().length();
	  if(length >= 5)
		  return true;
	  else
		  return false;
  }
}
