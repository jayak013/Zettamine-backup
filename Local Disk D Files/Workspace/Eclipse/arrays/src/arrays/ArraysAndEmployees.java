package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ArraysAndEmployees {
	
	public static void main(String[] args) {
		String[] names = {"Anand","Vijay","Vishal","Sudha","Beena",
							"Ziya","Kishore","Abigail","Kishore","Rohit",
							"Ajay","Rajesh","Zaheer"};
		
		Employee[] empArr = generateRandomEmployees(6, 301, 400, names, 10001, 20000);
		
		List<Employee> empList = Arrays.asList(empArr);
		
		for(Employee e:empList) {
			System.out.println(e);
		}
		System.out.println("~".repeat(20));
		
		Collections.sort(empList,getENameComparator());
		System.out.println("After sorting using comparable");
		
		for(Employee e:empList) {
			System.out.println(e);
		}
		
//		for(Employee employee: empArr) {
//			System.out.println(employee);
//		}
//		
//		System.out.println("~".repeat(20));
//		
//		Arrays.sort(empArr);
//		
//		System.out.println("After default Sorting - uses Comparable");
//		
//		for(Employee employee: empArr) {
//			System.out.println(employee);
//		}
//		System.out.println("~".repeat(20));
//		
//		Arrays.sort(empArr,getENameComparator());
//		
//		System.out.println("After Sorting based on names- uses comparator");
//		
//		for(Employee employee: empArr) {
//			System.out.println(employee);
//		}
//		System.out.println("~".repeat(20));
//		
//		Arrays.sort(empArr,getDNoSalaryComparator());
//		
//		System.out.println("After Sorting based on Dept and salary - uses comparator");
//		
//		for(Employee employee: empArr) {
//			System.out.println(employee);
//		}
//		System.out.println("~".repeat(20));
	}
	
	private static Employee[] generateRandomEmployees(int noOfEmps,
														int minEno,int maxEno
														,String[] names,
														int minSal,int maxSal) {
		Employee[] empArr = new Employee[noOfEmps];
		
		Random random = new Random();
		int dno = 10;
		
		for(int i = 0;i<noOfEmps;i++) {
			dno = (i%2 == 0)?10:20;
			empArr[i] = new Employee(random.nextInt(maxEno + 1 - minEno) + minEno,
													names[random.nextInt(names.length)],
													dno,
													random.nextInt(maxSal + 1 - minSal)+minSal);
		}
		
		return empArr;
	}
	
	private static Comparator<Employee> getENameComparator(){
		return new Comparator<Employee>() {
			public int compare(Employee e1,Employee e2) {
				return e1.getName().compareToIgnoreCase(e2.getName());
			}
		};
	}
	
	private static Comparator<Employee> getDNoSalaryComparator(){
		return new Comparator<Employee>() {
			public int compare(Employee e1,Employee e2) {
//				if(e1.getDno() == e2.getDno()) {
//					return e1.getSalary()-e2.getSalary();
//				}
//				return e1.getDno()-e2.getDno();
				int dnoCompare = e1.getDno()-e2.getDno();
				if(dnoCompare != 0) return dnoCompare;
				return e1.getSalary()-e2.getSalary();
			}
		};
	}
}
