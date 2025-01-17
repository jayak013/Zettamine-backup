package acc.code;


public class MainClass {
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		l.reverse();
		System.out.println(l);
	}
	
}


class Node{
	
	Object ele;
	Node next;
	
	public Node(Object e, Node n) {
		ele = e;
		next = n;
	}
	
}

class LinkedList<E>{
	
	private Node first = null;
	private Node last = null;
	private int count = 0;
	
	public void add(E e) {
		if(first==null) {
			first = new Node(e,null);
			last = first;
			count++;
			return;
		}
		
		last.next = new Node(e,null);
		last = last.next;
		count++;
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		Node curr = first;
		String output = "";
		while(curr!=null) {
			output = output + curr.ele+"  ";
			curr = curr.next;
		}
		return output;
	}
	
	public void reverse() {
		Node prev = null,next = null;
		Node curr = first;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		first = prev;
	}
	
	public void customReverse() {
		int counter = 1;
		Node prev = null,next = null;
		Node curr = first;
		
		while(curr!=null) {
			Node remCurr = curr;
			Node remFirst = remCurr;
			counter = 1;
			while(counter<=3) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				counter++;
			}
			first = prev;
		}
	}

}
