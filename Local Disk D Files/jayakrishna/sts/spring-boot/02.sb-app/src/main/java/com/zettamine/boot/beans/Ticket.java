package com.zettamine.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	
	@Value("NSMPS1393R")
	private String pnr;
	
	@Value("${zettamine.passenger.name}")
	private String passengerName;
	
	public Ticket() {
		System.out.println("Ticket :: Constructor");
	}

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", passengerName=" + passengerName + "]";
	}
	
	
	
}
