package logics.revise;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collec {
	
	
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<>();
		List<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Iterator<Integer> i = list.listIterator();
		int count = 0;
		while(i.hasNext()) {
			if(count++ == 2)
			list.remove(2);
			i.next();
		}
			
	}
}
