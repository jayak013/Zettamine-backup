package colllections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo01 {
	
	public static void main(String[] args) {
		PriorityQueue<String> topicPQ = new PriorityQueue<>();
											//for minHeap use the above context
//		PriorityQueue<String> topicPQ = new PriorityQueue<>(Comparator.reverseOrder());
											//for maxHeap use the above context
		
		topicPQ.offer("PostgreSQL");
		topicPQ.offer("Collections");
		topicPQ.offer("JDBC");
		topicPQ.offer("Multithreading & Concurrency");
		topicPQ.offer("IO Streams & NIO");
		
		//stage-1
		System.out.println("Size: " + topicPQ.size());
		System.out.println(topicPQ);
		System.out.println("~".repeat(30));
		
		//stage-2
		String currentTopic = topicPQ.peek();
		System.out.println("Value fetched by peek(): " + currentTopic);
		System.out.println(topicPQ);
		System.out.println("~".repeat(30));
		
		//stage-3
		currentTopic = topicPQ.poll();
		System.out.println("After calling poll() for first time: " + currentTopic);
		System.out.println(topicPQ);
		System.out.println("~".repeat(30));
		
		//stage-4
		currentTopic = topicPQ.poll();
		System.out.println("After calling poll() for second time: " + currentTopic);
		System.out.println(topicPQ);
		System.out.println("~".repeat(30));
		
		
	}
	
}
