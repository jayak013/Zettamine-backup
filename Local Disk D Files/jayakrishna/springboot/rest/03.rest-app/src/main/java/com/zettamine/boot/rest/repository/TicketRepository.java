package com.zettamine.boot.rest.repository;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository {
	
	private static Integer ticketId = 201779;
	
	public Integer generateTicketNumber() {
		return ticketId++;
	}
	
	public String generateTicketStatus() {
		int random = new Random().nextInt(2);
		if(random==0) return "Pending";
		else return "Successful";
	}
}
