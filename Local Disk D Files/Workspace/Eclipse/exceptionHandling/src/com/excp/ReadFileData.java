package com.excp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileData {
	public static void main(String[] args) {
		try {
			FileReader fReader = new FileReader("C:\\Users\\S Jaya Krishna\\Desktop\\SampleData.txt");
			try {
				int ch;
				while ((ch = fReader.read()) != -1) {
					System.out.print((char) ch);
				}
			} catch (IOException e) {
				System.out.println("error while reading the file");
			} finally {
				try {
					fReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("file doesn't exist");
		}
	}

}
