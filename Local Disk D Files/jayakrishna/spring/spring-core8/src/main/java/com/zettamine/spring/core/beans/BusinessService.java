package com.zettamine.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {
	
	@Autowired
	private Service1 ser1;
	@Autowired
	private Service2 ser2;

//	@Autowired
	public void setSer1(Service1 ser1) {
		System.out.println("ser1 SI");
		this.ser1 = ser1;
	}

//	@Autowired
	public void setSer2(Service2 ser2) {
		System.out.println("ser2 SI");
		this.ser2 = ser2;
	}

	public BusinessService(Service1 ser1, Service2 ser2) {
		System.out.println("BusinessService :: 2-ParamConstructor");
		this.ser1 = ser1;
		this.ser2 = ser2;
	}

	public BusinessService() {
		
	}
	
	@Override
	public String toString() {
		return "BusinessService [ser1=" + ser1 + ", ser2=" + ser2 + "]";
	}
	
	
	
}
