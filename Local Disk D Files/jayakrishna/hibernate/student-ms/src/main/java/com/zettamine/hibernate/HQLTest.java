package com.zettamine.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.SessionFactoryUtils;



public class HQLTest {
	
	public static void main(String[] args) {
		
		
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
		
		
		//to fetch all the students
//		String hql = "from Student";

		//to fetch a specific student by his name
//		String hql = "from Student where studentName='tja'";
		
		//to fetch all the records where they matches the given pattern
//		String hql = "from Student where studentName like '%a%'";
		
//		String hql = "from Student where studentId between ?1 and ?2";
		
//		String hql = "from Student order by studentName desc";
		
		session.beginTransaction();
		String hql = "";
		
		Query query = session.createQuery(hql);
		session.getTransaction().commit();
//		query.setParameter(1, 3);
//		query.setParameter(2, 4);
//		List<Student> list = query.list();
//		printStudents(list);
		
		session.close();
		sF.close();
	}

	private static void printStudents(List<Student> list) {
		for(Student s:list) System.out.println(s);
	}
	
}
