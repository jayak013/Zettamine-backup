package com.zettamine.mt;

import java.io.File;
import java.io.FileWriter;

public class MainApp {
	
	public static void main(String[] args) {
		Account jaya = new Account(7000);
		
		ATM atmThread = new ATM(jaya);
		GPay gPayThread = new GPay(jaya);
		
		atmThread.start();
		gPayThread.start();
	}
	
}
