package logics.revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuilderPatternCheck {
	
	public static void main(String[] args) {
		Student s1 = Student.builder()
		.id(1)
		.name("Jaya 1")
		.address("Annamayya")
		.build();
		
		Student s2 = Student.builder()
				.id(9)
				.name("Jaya 9")
				.address("Annamayya")
				.build();
		
		Student s3 = Student.builder()
				.id(99)
				.name("Jaya 99")
				.address("Annamayya")
				.build();
		
		List<Student> list = new ArrayList<>();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		List<Student> list2 = list.stream().filter(s->s.getId()%10==9).toList();
		
		System.out.println(list2);
		
		Set<Integer> s = new HashSet<>();
		
		Arrays.asList(1,4,4,2,3,3,4,5,6,7,8,9).stream().filter(e->!s.add(e)).distinct().forEach(System.out::println);
		
		Stream.iterate(new int[]{0,1},f->new int[]{f[1],f[0]+f[1]}).limit(25).forEach(e->System.out.println(e[0]));
		
		String pal = "Madam";
		
		boolean noneMatch = IntStream.rangeClosed(0,pal.length()/2).allMatch(i->pal.charAt(i)==pal.charAt(pal.length()-i-1));
		System.err.println(noneMatch);

		int num = 97;
		
		boolean prime = IntStream.range(2, num/2).noneMatch(i->num%i==0);
		System.out.println(prime);
		
		if(System.out.printf("Hello World!") != null) {
			
		}
	}
	
}

class Student{
	
	private Integer id;
	private String name;
	private String address;
	
	private Student(StudentBuilder studentBuilder) {
		this.id = studentBuilder.id;
		this.name = studentBuilder.name;
		this.address = studentBuilder.address;
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}



	public static class StudentBuilder{
		private Integer id;
		private String name;
		private String address;
		
		public StudentBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public StudentBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public StudentBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}
	
	public static StudentBuilder builder() {
		return new StudentBuilder();
	}
}
