package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.SessionFactoryUtils;

public class StudentDMLDemo {
	
	public static void main(String[] args) {
		Student student = new Student(2,"hithu","hithu@gmail.com");
		deleteStudent(student);
//		searchByGet(20);
	}
	
	public static void searchByLoad(Integer id) {
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
		try {
			Student st = session.load(Student.class, id); //supports lazy loading
			System.out.println(st);
		}catch(Exception e) {
			System.out.println("no records found...");
		}
		session.close();
		sF.close();
	}
	
	public static void searchByGet(Integer id) {
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
		Student st = session.get(Student.class, id); //supports eager loading
		if(st!=null) System.out.println(st);
		else System.out.println("no records found..."); 
		session.close();
		sF.close();
	}
	
	public static void updateStudent(Student st) {
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
		Student student = session.get(Student.class, st.getStudentId());
		if(student==null) {
			System.out.println("no records found..");
			return ;
		}
		Transaction transaction = session.beginTransaction();
		session.update(st);
		transaction.commit();
		session.close();
		sF.close();
	}
	
	public static Student deleteStudent(Student st) {
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
		Student student = session.get(Student.class, st.getStudentId());
		if(student==null) {
			System.out.println("no records found..");
			return null;
		}
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
		session.close();
		sF.close();
		return student;
	}
}
