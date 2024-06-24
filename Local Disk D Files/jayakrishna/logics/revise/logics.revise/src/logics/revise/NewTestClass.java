package logics.revise;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewTestClass {
	
	
	public static void main(String[] args) {
		
		Thread.currentThread().setPriority(5);
		
		
		ThreadTest t = new ThreadTest();
		t.setPriority(10);
		t.start();
		IntStream.range(1, 10).forEach(e->System.out.println("main thread"));
		
	}
	
	
}

class ThreadTest extends Thread{
	@Override
	public void run() {
		IntStream.range(1, 10).forEach(e->System.out.println("child thread"));
	}
}

