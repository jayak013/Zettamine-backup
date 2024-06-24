package acc.code;

import java.util.Arrays;
import java.util.List;

public class Accenture {
	
	private List<Integer> list;
	
	public Accenture(List<Integer> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,4,8,9,1,3);
		
		Accenture acc = new Accenture(list);
		
		Thread t1 = new Thread(acc::printEven);	
		t1.setName("EvenThread");
		Thread t2 = new Thread(acc::printOdd);
		t2.setName("OddThread");
		
		t1.start();
		t2.start();
	}
	
	public synchronized void printEven() {
//        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)%2==0) {
                	System.out.println(list.get(i)+" -> "+Thread.currentThread().getName());
                }else {
                	try {
                		notify();
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
//            }
            notify();
        }
    }

    public synchronized void printOdd() {
//        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
            	 if(list.get(i)%2!=0) {
                 	System.out.println(list.get(i)+" -> "+Thread.currentThread().getName());
                 }else {
                 	try {
                     	notify();
 						wait();
 					} catch (InterruptedException e) {
 						e.printStackTrace();
 					}
                 }
            }
            notify();
//        }
    }
	
}



