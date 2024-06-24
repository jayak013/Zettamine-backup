package customgenerics;

public class CheckTest {
	public static void main(String[] args) {
		Test<Employee> test = new Test<>();
		Employee e1 = new Employee(1, "Jaya Krishna");
		Employee e2 = new Employee(2, "Bhargav");
		Certification c1 = new Certification("Java");
		Test t = new Test();
		t.addElements(e1);
		t.addElements(e2);
		t.addElements(c1);
		System.out.println(t.list);
	}
}
