package com.zettamine.boot.rest.controllers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.entity.Ticket;
import com.zettamine.boot.rest.exceptions.TicketNotFoundException;
import com.zettamine.boot.rest.models.Passenger;
import com.zettamine.boot.rest.repository.TicketRepository;


@RestController
@RequestMapping("/irctc")
public class TicketRestController {
	private TicketRepository ticketRepo;
	
	public TicketRestController(TicketRepository ticketRepo) {
		super();
		this.ticketRepo = ticketRepo;
	}

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
		
		ticket.setTicketFare(1750f);
		
		LocalDate date = LocalDate.now();
		ticket.setDateOfBooking(date);
		
		ticket.setBookingStatus(new Random().nextBoolean() ? "CONFIRMED" : "WAITING");
		while(true) {
			String pnr = generatePNR();
			if(!ticketRepo.existsById(pnr)) {
				ticket.setPnr(pnr);
				ticketRepo.save(ticket);
				break;
			}
		}
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	private String generatePNR() {
		UUID uuid = UUID.randomUUID();
		String randomText = uuid.toString();
		randomText = randomText.replace("-","");
		String pnr = randomText.substring(0, 6).toUpperCase();
		return pnr;
	}
	
	@GetMapping(path = "/ticket/search/{pnr}",
				produces = {"application/xml", "application/json"})
	public ResponseEntity<?> findTicketByPnr(@PathVariable String pnr){
		Ticket ticket = null;
		Optional<Ticket> optTicket = ticketRepo.findById(pnr);
		if(optTicket.isPresent()) {
			ticket = optTicket.get();
			return ResponseEntity.ok(ticket);
		}else {
			return new ResponseEntity<String>("no booking done on PNR: " + pnr, HttpStatus.OK);
		}		
	}
	
	@DeleteMapping(path = "/ticket/cancel/{pnr}")
	public ResponseEntity<?> cancelTicketById(@PathVariable String pnr){
		if(ticketRepo.existsById(pnr)) {
			Ticket ticketToDelete = ticketRepo.findById(pnr).get();
			
			ticketRepo.deleteById(pnr);
			return new ResponseEntity<String>(String.format("Ticket with PNR: %-6s got Cancellend and the refund of Rs. %.2f will hit your a/c in 06 working days", pnr, ticketToDelete.getTicketFare()), HttpStatus.OK);
		}
		//throw new RuntimeException(String.format("Ticket with PNR: %-6s is not available!", pnr));
		throw new TicketNotFoundException(String.format("Ticket with PNR: %-6s is not available!", pnr));
	}
}
