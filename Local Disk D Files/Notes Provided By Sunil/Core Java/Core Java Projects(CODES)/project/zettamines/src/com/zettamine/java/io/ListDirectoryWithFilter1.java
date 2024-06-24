package com.zettamine.java.io;

import java.io.File;
import java.io.FilenameFilter;

public class ListDirectoryWithFilter1 {

	public static void main(String[] args) {
		File dir = new File("src/com/zettamine/java/oops");
		if(dir.isDirectory()) {			
			String[] files = dir.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					if(name.startsWith("S") && name.endsWith(".java"))
						return true;
					return false;
				}
			});
			
			for(String f : files) {
				System.out.println("----> " + f);
			}
		}
	}
}

