package com.zettamine.boot.rest.controllers;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.models.Passenger;
import com.zettamine.boot.rest.models.Ticket;

@RestController
@RequestMapping("/irctc")
public class TicketRestController {
	
	@PostMapping(value = "ticket/new",
				 consumes = {"application/xml", "application/json"},
				 produces = {"application/xml", "application/json"})
	public ResponseEntity<?> newTicketBooking(@RequestBody Passenger passenger){
		//--logic to generate the ticket for passenger and to save in DB

		Ticket ticket = new Ticket();
		
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTrainNo(passenger.getTrainNo());
		
		//ticket.setTicketFare(((new Random().nextFloat()*10000)));
		ticket.setTicketFare((new Random().nextFloat(1000,2000)));
		
		LocalDate date = LocalDate.now();
		ticket.setDateOfBooking(date);
		
		ticket.setBookingStatus(new Random().nextBoolean() ? "CONFIRMED" : "WAITING");
		ticket.setPnr(generatePNR());
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	private String generatePNR() {
		UUID uuid = UUID.randomUUID();
		String randomText = uuid.toString();
		randomText = randomText.replace("-","");
		String pnr = randomText.substring(0, 6).toUpperCase();
		return pnr;
	}
}
