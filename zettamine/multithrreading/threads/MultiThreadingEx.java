package com.zettamine.java.threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class Naturals extends Thread{
	private File dir;
	private String fileName;
	
	public Naturals(File dir, String fileName) {
		super();
		this.dir = dir;
		this.fileName = fileName;
	}
	public void run() {
		writeData();
	}
	public void writeData() {
		try (Writer fout = new FileWriter(new File(dir, fileName))){
			for(int i=1; i<=10; i++) {
				fout.write(Thread.currentThread().getName()+" - " + i + "\n");
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Evens extends Thread{
	private File dir;
	private String fileName;
	
	public Evens(File dir, String fileName) {
		super();
		this.dir = dir;
		this.fileName = fileName;
	}
	public void run() {
		writeData();
	}
	
	public void writeData() {
		
		try (Writer fout = new FileWriter(new File(dir, fileName))){
			for(int i=1; i<=10; i++) {
				fout.write(Thread.currentThread().getName()+" - " + (i*2) + "\n");
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class MultiThreadingEx {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\Sunil Joseph\\Desktop\\normal");
		long startTime = System.currentTimeMillis();
		System.out.println("start time = " + startTime);
		Thread nat = new Naturals(dir, "naturals.txt");
		Thread eve = new Evens(dir, "evens.txt");
		
		nat.setName("NATURAL");
		eve.setName("EVEN   ");
		
		nat.start();
		eve.start();
		try {
			nat.join();
			eve.join();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();	
		System.out.println("end time = " + endTime);
		
		System.out.println("execution time = " + (endTime - startTime));
	}

}
