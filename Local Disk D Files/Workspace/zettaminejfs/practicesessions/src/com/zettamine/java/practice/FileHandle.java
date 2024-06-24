package com.zettamine.java.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandle {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File f = 
	new File("src/com/zettamine/java/practice/Car.java");
		System.out.println(f.exists());
		System.out.println(f.canExecute());
		System.out.println(f.canRead());
		System.out.println(f.canWrite());
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		System.out.println(f.getAbsolutePath());
		FileReader fR = new FileReader(f);
		if(f.exists()) {
			int read = 0;
			while(read!=-1) {
				read = fR.read();
				System.out.print((char)read);
			}
		}
		if(f.exists()) {
			BufferedReader buf = new BufferedReader(fR);
			int read = buf.read();
			while(read!=-1) {
				
			}
		}
	}
}
