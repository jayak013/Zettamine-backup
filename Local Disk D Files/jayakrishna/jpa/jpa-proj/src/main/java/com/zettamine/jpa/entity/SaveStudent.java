package com.zettamine.jpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SaveStudent {

	public static void main(String[] args) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("students-hibernate");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("students-eclipselink");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		
		Student st = new Student();
		st.setStudentId(106);
		st.setStudentName("Suraj");
		
		em.persist(st);
		
		etx.commit();
		em.close();
		emf.close();
	}

}
