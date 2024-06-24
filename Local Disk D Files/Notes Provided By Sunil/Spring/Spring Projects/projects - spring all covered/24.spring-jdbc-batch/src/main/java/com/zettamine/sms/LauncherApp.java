package com.zettamine.sms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.sms.dao.StudentDAO;
import com.zettamine.sms.dto.Student;


public class LauncherApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("student-beans.xml");

		StudentDAO dao = (StudentDAO)context.getBean("studentDao");
		
		List<Student> students = new ArrayList<Student>();
		
		for(int i=1001; i<=3000; i++) {
			Student st = new Student(i, "Zetta-"+(i-1000));
			students.add(st);
		}
		
		dao.studentBatchInsertion(students);
		System.out.println("----- done ------");
	}

}
