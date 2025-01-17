package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zettamine.hibernate.entity.Student;

public class SaveStudent {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml"); //XML Parsing - DOM Parser
		
		SessionFactory sfactory = config.buildSessionFactory();
		Session session = sfactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student st = new Student();
		st.setStudentId(101);
		st.setStudentName("Sanjay");
		st.setStudentEmail("sanjay@gmail.com");
		
		session.save(st);
		System.out.println("--------------------------------------------\n");
		
		tx.commit();
		
		session.close();
		sfactory.close();
	}

}
