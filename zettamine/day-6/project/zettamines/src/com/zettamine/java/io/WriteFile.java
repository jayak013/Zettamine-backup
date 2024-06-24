package com.zettamine.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {
	public static void main(String[] args) {
		try {
			OutputStream out = new FileOutputStream("src/com/zettamine/java/io/zettamine.txt");
			//OutputStream out = new FileOutputStream("src/com/zettamine/java/io/zettamine.txt", true);
			
			String str = "Revolutionising Enterprise Business Solutions. We, at ZettaMine, believe that technology and innovation shape the future.\n";
			byte[] b = str.getBytes();
			
			out.write(b);
			System.out.println("file saved");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
