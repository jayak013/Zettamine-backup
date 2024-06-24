package com.excp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			FileReader reader = new FileReader("admission.properties.txt");
			
			prop.load(reader);
			
			System.out.println(prop.getProperty("maxAge"));
			System.out.println(prop.getProperty("minAge"));
			System.out.println(prop.getProperty("acceptedNationality"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
