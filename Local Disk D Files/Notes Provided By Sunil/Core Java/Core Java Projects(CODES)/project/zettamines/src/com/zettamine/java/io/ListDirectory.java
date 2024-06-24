package com.zettamine.java.io;

import java.io.File;

public class ListDirectory {

	public static void main(String[] args) {
		File dir = new File("src/com/zettamine/java/oops");
		if(dir.isDirectory()) {
			/*
			String[] files = dir.list();
			for(String f : files) {
				System.out.println("----> " + f);
			}
			*/
			
			File[] files = dir.listFiles();
			for(File f : files) {
			  if(f.isFile())	
				System.out.printf("%-25s   %d\n",f.getName(),f.length());
			}
		}

	}

}
