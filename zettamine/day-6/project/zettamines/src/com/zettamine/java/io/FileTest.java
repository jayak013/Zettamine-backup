package com.zettamine.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) throws IOException {
		//File f = new File("src/../src/Test.java");
		File f = new File("src/Test.java");
		System.out.println("file exists = " + f.exists());
		
		if(f.exists()) {
			System.out.println("is file = " + f.isFile());
			System.out.println("is directory = " + f.isDirectory());
			
			System.out.println("name = " + f.getName());
			System.out.println("is absolute path = " + f.isAbsolute());
			System.out.println("path = " + f.getPath());
			System.out.println("absolute path = " + f.getAbsolutePath());
			System.out.println("canonical path = " + f.getCanonicalPath());
			
			System.out.println("file size = " + f.length() + " bytes");
			
			System.out.println("can read = " + f.canRead());
			System.out.println("can write = " + f.canWrite());
			System.out.println("is hidden = " + f.isHidden());
			System.out.println("is executable = " + f.canExecute());
			
			System.out.println("parent directory = " + f.getParent());
			
			long time = f.lastModified();
			Date d = new Date(time);
			System.out.println("Test.java is modified on " + d);
		}
	}

}
