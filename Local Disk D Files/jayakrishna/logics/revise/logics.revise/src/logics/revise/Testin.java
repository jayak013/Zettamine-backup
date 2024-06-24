package logics.revise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Testin {
	
	
	public static void main(String[] args) {
		Studentt s1 = new Studentt("jaya", "mech", "male");
		Studentt s2 = new Studentt("kittu", "mech", "male");
		Studentt s3 = new Studentt("hari", "cse", "male");
		Studentt s4 = new Studentt("ganesh", "cse", "male");
		Studentt s5 = new Studentt("zai", "cse", "female");
		Studentt s6 = new Studentt("mom", "cse", "female");
		Studentt s7 = new Studentt("dad", "civil", "male");
		
		List<Studentt> list = new ArrayList<>();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		
		Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(Studentt::getDept,Collectors.mapping(Studentt::getName, Collectors.toList())));
		System.err.println(collect);
	}
	
}

class Studentt{
	private String name;
	private String dept;
	private String gender;
	@Override
	public String toString() {
		return "Studentt [name=" + name + ", dept=" + dept + ", gender=" + gender + "]";
	}
	public Studentt(String name, String dept, String gender) {
		super();
		this.name = name;
		this.dept = dept;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept, gender, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studentt other = (Studentt) obj;
		return Objects.equals(dept, other.dept) && Objects.equals(gender, other.gender)
				&& Objects.equals(name, other.name);
	}
	
	
	
}
