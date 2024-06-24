package colllections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class ArrayDequeDemo {
	
	public static void main(String[] args) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		deque.offer(35);//adding is done at the end of Queue
		deque.offer(24);
		deque.offer(10);
		System.out.println(deque);
		
		deque.offerFirst(67);
		System.out.println(deque);//adding is done at the start of the Queue
		
		deque.offerLast(6);
		System.out.println(deque);
		
		List<Integer> list = new LinkedList<>();
		list.add(-14);
		list.add(-8);
		list.add(-59);
		deque.addAll(list);//Adding of the elements is done at the end of the Queue
		System.out.println(deque);
		System.out.println("~".repeat(30));
		
		Integer res = deque.peek();
		System.out.println("peek(): " + res);
		
		res = deque.peekFirst();
		System.out.println("peek(): " + res);
		
		res = deque.peekLast();
		System.out.println("peekLast(): " + res);
		System.out.println("~".repeat(30));
		
		System.out.println(deque);
		res = deque.poll();
		System.out.println("first poll(): "+ res);
		System.out.println(deque);
		
		res = deque.pollFirst();
		System.out.println("first pollFisrt(): "+ res);
		System.out.println(deque);
		
		res = deque.pollLast();
		System.out.println("first pollLast(): "+ res);
		System.out.println(deque);
		
		
	}
	
}
