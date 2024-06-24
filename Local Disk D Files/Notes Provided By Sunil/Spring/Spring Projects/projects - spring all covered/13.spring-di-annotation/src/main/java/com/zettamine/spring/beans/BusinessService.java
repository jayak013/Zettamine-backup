package com.zettamine.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {
	@Autowired
	private Service1 ser1;
	
	//@Autowired
	private Service2 ser2;
	
	public BusinessService() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@Autowired
	public BusinessService(Service1 ser1, Service2 ser2) {
		super();
		this.ser1 = ser1;
		this.ser2 = ser2;
	}
	//@Autowired
	public void setSer1(Service1 ser1) {
		this.ser1 = ser1;
	}
	//@Autowired
	public void setSer2(Service2 ser2) {
		this.ser2 = ser2;
	}

	@Override
	public String toString() {
		return "BusinessService [ser1=" + ser1 + ", ser2=" + ser2 + "]";
	}	
}
