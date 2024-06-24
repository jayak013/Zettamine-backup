package colllections;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
	
	public static void main(String[] args) {
		Stack<String> topicStack = new Stack<>();
		
		topicStack.push("Collections");
		topicStack.push("PostgreSQL");
		topicStack.push("JDBC");
		topicStack.push("Multithreading & Concurrency");
		topicStack.push("IO Streams with NIO");
		
		System.out.println(topicStack.size());
		System.out.println(topicStack.toString());
		System.out.println("~".repeat(30));
		
		String currentTopic = topicStack.peek();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println("After calling the peek() method, the size is: "+topicStack.size());
		System.out.println(topicStack.toString());
		System.out.println("~".repeat(30));
		
		currentTopic = topicStack.pop();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println("After calling the pop() method {first time}, the size is: "+topicStack.size());
		System.out.println(topicStack.toString());
		System.out.println("~".repeat(30));
		
		currentTopic = topicStack.pop();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println("After calling the pop() method {second time}, the size is: "+topicStack.size());
		System.out.println(topicStack.toString());
		System.out.println("~".repeat(30));
		
		System.out.println("Checking of empty status: " + topicStack.empty());
		System.out.println("Searching for JDBC on topic stack: "
								+ topicStack.search("JDBC"));
		System.out.println("Searching for Multithreading & Concurrency on topic stack: " 
								+ topicStack.search("Multithreading & Concurrency"));
		System.out.println("~".repeat(30));
		
		System.out.println("size before traversing with an iterator: " + topicStack.size());
		Iterator<String> topicItr = topicStack.iterator();
		while(topicItr.hasNext())
			System.out.println(topicItr.next());
		System.out.println("size of the topicStack after traversing using iterator: "  
												+ topicStack.size());
		
		for(String s:topicStack)
			System.out.println(s);
		System.out.println("size of the topicStack after traversing using forEach loop: "  
				+ topicStack.size());
		
		for(int i = 0;i < topicStack.size();i++)
			System.out.println(topicStack.get(i));
		System.out.println("After traversing on topicStack for loop & get(idx): "  
				+ topicStack.size());
		

//		for(int i = 0;i < topicStack.size();i++)
//			System.out.println(topicStack.pop());	//here the boundary value is 
//													//ignored as the for loop condition become false
//		System.out.println("After traversing on topicStack for loop & get(idx): "  
//				+ topicStack.size());
		
		while(!topicStack.empty())
			System.out.println(topicStack.pop());
		System.out.println("After traversing on topicStack while loop: "  
				+ topicStack.size());
	}
}
