package colllections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo02 {
	
	public static void main(String[] args) {
//		PriorityQueue<Student> stuQ = new PriorityQueue<>();
//		PriorityQueue<Student> stuQ = new PriorityQueue<>(Comparator.reverseOrder());
		
//		PriorityQueue<Student> stuQ = 
//				new PriorityQueue<>(new Comparator<Student>() {
//
//					@Override
//					public int compare(Student o1, Student o2) {
//						return o1.getRank()-o2.getRank();
//					}
//					
//		});
		
		PriorityQueue<Student> stuQ = 
				new PriorityQueue<>(new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						int groupDiff = o1.getGroupId() - o2.getGroupId();
						if(groupDiff==0) {
							return o1.getStuName().compareTo(o2.getStuName());
						}
						return groupDiff;
					}
					
		});
		
		
		stuQ.add(new Student(276, "Vishal", 20, 23));
		stuQ.add(new Student(263, "Beena", 10, 8));
		stuQ.add(new Student(280, "Abigail", 20, 12));
		stuQ.add(new Student(271, "Vishal", 20, 32));
		stuQ.add(new Student(206, "Ajay", 10, 2));
		
		System.out.println(stuQ);
		
		Student stu = stuQ.poll();
		System.out.println("After First poll()");
		System.out.println("Poll result: " + stu);
		System.out.println(stuQ);
		
		stu = stuQ.poll();
		System.out.println("After Second poll()");
		System.out.println("Poll result: " + stu);
		System.out.println(stuQ);
	}
	
}
