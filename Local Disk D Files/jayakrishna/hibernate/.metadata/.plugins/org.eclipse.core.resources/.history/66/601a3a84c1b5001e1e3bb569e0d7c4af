package com.zettamine.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zettamine.hibernate.entity.Student;

public class SaveStudent {
	
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml"); //XML Parsing - DOM Parser
		
		SessionFactory sF = cfg.buildSessionFactory();
		Session session = sF.openSession();
		Transaction transaction = session.beginTransaction();
		char option = 0;
		do {
			Scanner scn = new Scanner(System.in);
			System.out.println("enter the student name and email: ");
			String name = scn.next();
			String email = scn.next();
			Student st = new Student(name,email);
			session.save(st);
			System.out.println("Do you want to add more students [Y/N]: ");
			option = scn.next().charAt(0);
		}while(option=='y' || option=='Y');
		transaction.commit();
		session.close();
		sF.close();
	}
	
}
