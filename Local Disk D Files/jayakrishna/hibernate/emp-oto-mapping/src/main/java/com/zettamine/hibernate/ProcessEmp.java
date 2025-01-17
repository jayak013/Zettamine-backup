package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Address;
import com.zettamine.hibernate.entity.Employee;
import com.zettamine.hibernate.utils.SessionFactoryUtil;


public class ProcessEmp {
	
	public static void main(String[] args) {
		SessionFactory sF = SessionFactoryUtil.getseSessionFactory();
		Session session = sF.openSession();
		Session session1 = sF.openSession();//for checking second-level cache
		session.beginTransaction();
		
		Address address = session.get(Address.class, 2);
		System.out.println(address.getCity());
		
		session.remove(address);
//		session.getTransaction().commit();
		
//		Employee emp = new Employee();
//		Address addr = new Address();
//		
//		emp.setEmployeeName("Kabar");
//		
//		addr.setStreet("Swetha Laya");
//		addr.setCity("Yerragadda");
//		addr.setState("Telangana");
//		
//		addr.setEmployee(emp);
//		emp.setAddress(addr);
//		
//		session.persist(addr);
//		
//		session.getTransaction().commit();
		
//		Employee employee = session.get(Employee.class, 3);
//		System.out.println(employee.getEmployeeName());//eager loading is happening 
//		System.out.println(employee.getAddress()+" --->LAZY LOADING");//lazy loading is happening as fetchType is set to LAZY manually
//		
//		System.out.println("\nsame session again fetch same employee for checking first-level cache[no query will generate]");
//		Employee employee1 = session.get(Employee.class, 1);
//		System.out.println(employee1);
		
//		System.out.println("\nnew session again fetch same employee for checking second-level cache[no query will generate]");
//		Employee employee2 = session.get(Employee.class, 1);
//		System.out.println(employee1);
//		
//		emp.setEmployeeName("Shiva Mallesh");
		
//		Address addr = new Address();
//		addr.setStreet("Kundhan Bagh");
//		addr.setCity("Begumpet");
//		addr.setState("Telangana");
		
//		emp.setAddress(addr);
		
//		session.persist(emp);
		
//		session.getTransaction().commit();
		session.close();
		sF.close();
	}
	
}
