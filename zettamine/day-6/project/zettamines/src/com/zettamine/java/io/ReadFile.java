package com.zettamine.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class ReadFile {

	public static void main(String[] args) {

		try {
			InputStream fin = new FileInputStream("src/com/zettamine/java/io/java.txt");
			/*
			System.out.println("no of characters to be read = " + fin.available());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println("no of characters to be read = " + fin.available());
			*/
			
			//readFileContentsCharByChar(fin);
			
			//readFileContentsCompletely(fin);
			
			readFileContentsLineByLine(fin);
			
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void readFileContentsLineByLine(InputStream fin) {
		Reader fileSource = new InputStreamReader(fin); //to convert bytestream to character stream
		BufferedReader br = new BufferedReader(fileSource);
		String str;
		try {
			while((str = br.readLine())!= null) {
				System.out.println(str);
				TimeUnit.SECONDS.sleep(2);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private static void readFileContentsCompletely(InputStream fin) {
		try {
			byte[] b = new byte[fin.available()];
			fin.read(b);
			String str = new String(b);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void readFileContentsCharByChar(InputStream fin) {
		int n;
		try {
			n = fin.read();
			while(n != -1) {
				System.out.print((char)n);
				Thread.sleep(100);
				n = fin.read();
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
