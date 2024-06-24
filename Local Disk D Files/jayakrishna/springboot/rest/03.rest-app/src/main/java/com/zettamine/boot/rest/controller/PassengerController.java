package com.zettamine.boot.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.entities.Passenger;
import com.zettamine.boot.rest.entities.Ticket;
import com.zettamine.boot.rest.repository.TicketRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/passenger")
@Tag(name = "Ticket Booking Controller")
public class PassengerController {
	
	
	private TicketRepository tRepo;
	
	private List<Ticket> listOfTickets = new ArrayList<>();
	
	public PassengerController(TicketRepository tRepo) {
		this.tRepo = tRepo;
	}

	@PostMapping(path = "/generate-ticket",produces = {"application/xml","application/json"})
	public ResponseEntity<Ticket> generateTicket(@RequestBody Passenger passenger) {
		
		Ticket ticket = new Ticket();
		ticket.setPnr(tRepo.generateTicketNumber());
		ticket.setDateOfBooking(new Date());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setFare(passenger.getFare());
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setTicketStatus(tRepo.generateTicketStatus());
		
		listOfTickets.add(ticket);
		
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTickets(){
		return new ResponseEntity<List<Ticket>>(listOfTickets,HttpStatus.OK);
	}
	
	@GetMapping(path = "/search/{pnr}",produces = {"application/json"})
	public ResponseEntity<?> searchTicket(@PathVariable Integer pnr){
		Ticket ticket = listOfTickets.stream().filter(tk->tk.getPnr().equals(pnr)).findFirst().orElse(null);
		if(ticket!=null) {
			return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No matches found for the given PNR",HttpStatus.BAD_REQUEST);
	}
	
}
