package com.zettamine.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static SessionFactory sF = null;
	public static SessionFactory getseSessionFactory() {
		if(sF==null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml"); //XML Parsing - DOM Parser
			sF = cfg.buildSessionFactory();
		}
		return sF;
	}
}
