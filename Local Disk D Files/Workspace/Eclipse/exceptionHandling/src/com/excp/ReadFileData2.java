package com.excp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileData2 {
	public static void main(String[] args) {
		String fileName = "C:\\Users\\S Jaya Krishna\\Desktop\\SampleData.txt";
		try {
			readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void readFile(String filePath) throws FileNotFoundException {
		 final FileReader fReader = 
				new FileReader(filePath);
		try (fReader) {
			int ch;
			while ((ch = fReader.read()) != -1) {	//Remember this line
				System.out.print((char) ch);		//Assigning and comparing happening
			}										//same time.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
