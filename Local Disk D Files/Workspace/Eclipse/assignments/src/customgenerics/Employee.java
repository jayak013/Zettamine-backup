package customgenerics;

public class Employee {
	public int id;
	public String name;
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
