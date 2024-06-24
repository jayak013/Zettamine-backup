package com.zettamine.ems;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.entity.Employee;

public class LauncherApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-beans.xml");
		
		EmployeeDAO dao = context.getBean(EmployeeDAO.class);
		
		Employee emp = dao.findEmployeeByNo(101);
		System.out.println(emp);
		System.out.println();
		
		
		List<Employee> emps = dao.findAll();
		emps.stream().forEach(System.out::println);
		System.out.println();
		
		emp = new Employee(107, "Siva", 8750.5f);
		int n = dao.saveEmployee(emp);
		System.out.println("employee saved = " + n);
		
		
		((AbstractApplicationContext)context).close();
	}

}
