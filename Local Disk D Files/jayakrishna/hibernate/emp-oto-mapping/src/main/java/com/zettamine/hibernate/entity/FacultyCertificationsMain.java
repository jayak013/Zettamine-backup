package com.zettamine.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.utils.SessionFactoryUtil;

public class FacultyCertificationsMain {
	
	public static void main(String[] args) {
		Faculty faculty = new Faculty();
		faculty.setFacultyName("Chari");
		
		Set<Batch> set = new HashSet<>();
		set.add(new Batch("java",faculty));
		set.add(new Batch("python",faculty));
		set.add(new Batch("react",faculty));
		set.add(new Batch("java",faculty));
		
//		set.add(new Batch("java"));
//		set.add(new Batch("python"));
//		set.add(new Batch("react"));
//		set.add(new Batch("java"));
		
		faculty.setBatches(set);
		
		SessionFactory sF = SessionFactoryUtil.getseSessionFactory();
		Session session = sF.openSession();
		session.beginTransaction();
		session.persist(faculty);
		session.getTransaction().commit();
		session.close();
		sF.close();
	}
	
}
