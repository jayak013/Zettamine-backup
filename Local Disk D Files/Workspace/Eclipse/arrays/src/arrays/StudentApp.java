package arrays;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println(Student.getCount());
		
		Student s1,s2;
		
		s1 = new Student(101,"Anand");
		System.out.println(Student.getCount());
		s2 = new Student(344,"Beena");
		System.out.println(Student.getCount());
		System.out.println("End of program.");
	}
}
