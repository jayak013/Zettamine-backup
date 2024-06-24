package com.zettamine.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.zettamine.hibernate.entity.ProductDetails;
import com.zettamine.hibernate.utils.SessionFactoryUtils;

public class ProductDetailsHQL {
	
	private static final String ProductDetails = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sF = SessionFactoryUtils.getseSessionFactory();
		Session session = sF.openSession();
//		ProductDetails pD = new ProductDetails();
//		pD.setProductName("TV");
//		pD.setProductPrice(30000.00);
//		
//		session.beginTransaction();
//		session.save(pD);
//		session.getTransaction().commit();
		String hql = "from ProductDetails";
		Criteria cq = session.createCriteria(ProductDetails.class);//first we have to our entity class here so that we can get the criteria obj
		//I am using addOrder function, it contains many functionalities.
		//Check this link---> {https://www.digitalocean.com/community/tutorials/hibernate-criteria-example-tutorial}
		Criteria addOrder = cq.addOrder(Order.desc("productId"));//by using addOrder I can choose desc or asc, here I am choosing based on which column criteria is happening
		Criteria setFirstResult = addOrder.setFirstResult(0);//from which index results has to visible
		setFirstResult.setMaxResults(1); //maximum how many records can be visible
		List list = setFirstResult.list();// and then remaining results as a list of objs, then print
		System.out.println(list);
		session.close();
		sF.close();
		
	}
	
}
