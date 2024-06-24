package customgenerics;

public class ListOfStudents{
	public static void main(String[] args) {
		Student s1 = new Student(1, "Jaya", 23);
		Student s2 = new Student(2, "Krishna", 22);
		Student s3 = new Student(3, "Seetha", 23);
		Student s4 = new Student(4, "Hari", 20);
		Student s5 = new Student(5, "Priya", 22);
		Student s6 = new Student(6, "Lakshmi", 38);
		Student s7 = new Student(7, "Sreenu", 40);
		Student s8 = new Student(8, "Shiva", 24);
		Student s9 = new Student(9, "Bhargav", 25);
		Student s10 = new Student(10, "Sai", 24);
		Student s11 = new Student(11, "Naveen", 23);
		
		CustomArrayList sList = new CustomArrayList();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		sList.add(s6);
		sList.add(s7);
		sList.add(s8);
		sList.add(s9);
		sList.add(s10);
		sList.add(s11);
		
		
		
		System.out.println(sList.size());
		System.out.println(sList);
		System.out.println(sList.get(2));
		System.out.println(sList.size());
		sList.add(10,s11);
		System.out.println(sList);
	}
}
