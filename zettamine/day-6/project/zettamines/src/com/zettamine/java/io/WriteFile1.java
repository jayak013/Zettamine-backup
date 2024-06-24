package com.zettamine.java.io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile1 {

	public static void main(String[] args) {
		try {
			Writer out = new FileWriter("src/com/zettamine/java/io/zettamine1.txt", true);
			
			String str = "Revolutionising Enterprise Business Solutions. We, at ZettaMine, believe that technology and innovation shape the future.\n";
					
			out.write(str);
			System.out.println("file saved");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
