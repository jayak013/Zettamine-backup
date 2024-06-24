package colllections;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListDemo {
	
	public static void main(String[] args) {
		Queue<String> topicQ = new LinkedList<>();
		topicQ.offer("Collections");
		topicQ.offer("PostegreSQL");
		topicQ.offer("JDBC");
		topicQ.offer("Multithreading & Concurrency");
		topicQ.offer("IO Streams & NIO");
		
		System.out.println(topicQ.size());
		System.out.println(topicQ);
		System.out.println("~".repeat(30));
		
		String currentTopic = topicQ.peek();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println(topicQ);
		System.out.println("Size after calling peek(): " + topicQ.size());
		
		currentTopic = topicQ.poll();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println(topicQ);
		System.out.println("Size after calling poll(){first time}: " + topicQ.size());
		
		currentTopic = topicQ.remove();
		System.out.println("Current Topic: " + currentTopic);
		System.out.println(topicQ);
		System.out.println("Size after calling remove(){first time}: " + topicQ.size());
		
//		topicQ.clear();
//		System.out.println("size after calling clear(): " + topicQ.size());
//		System.out.println(topicQ.poll());
//		
//		Iterator<String> topicQItr = topicQ.iterator();
//		while(topicQItr.hasNext())
//			System.out.println(topicQItr.next());
		//Iterator uses extra resources compared to while and for loop
		//as they deal with the copy of the collection object
		
		while(!topicQ.isEmpty()) {
			System.out.println(topicQ.poll());
		}
		System.out.println("size of the topicQ after using while loop with poll(): " + topicQ.size());
		System.out.println("~".repeat(30));
		
//		topicQ.
//		if(topicQ instanceof List) {
			List<String> topicL = (List<String>) topicQ;
//			topicL.
			Deque<String> topicDQ = (Deque<String>) topicQ;
//			topicDQ.
			LinkedList<String> topicLL = (LinkedList<String>) topicQ;
//			topicLL.
		
		
	}
	
}
