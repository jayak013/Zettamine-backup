package com.zettamine.boot.rest.controllers;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.dto.Passenger;
import com.zettamine.boot.rest.entity.Ticket;
import com.zettamine.boot.rest.exceptions.TicketNotFoundException;
import com.zettamine.boot.rest.repository.TicketRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/irctc")
@Tag(name = "Ticket Booking Controller", 
	 description = "Boook, Search, Cancel, Reschedule Ticket")
public class TicketRestController {
	private TicketRepository ticketRepo;
	
	public TicketRestController(TicketRepository ticketRepo) {
		super();
		this.ticketRepo = ticketRepo;
	}
	
	@Operation(summary = "New Ticket Booking",
		       description = "booking a new train ticket based on passenger info")
	@ApiResponses(
			  @ApiResponse(responseCode = "201",
                    description = "TICKET CREATED")
			)
	
	@PostMapping(value = "ticket/new",
				 consumes = {"application/xml", "application/json"},
				 produces = {"application/xml", "application/json"})
	public ResponseEntity<?> newTicketBooking(@Valid @RequestBody Passenger passenger){
		//--logic to generate the ticket for passenger and to save in DB

		Ticket ticket = new Ticket();
		/*
		ticket.setPassengerName(passenger.getPassengerName());
		ticket.setFromStation(passenger.getFromStation());
		ticket.setToStation(passenger.getToStation());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTrainNo(passenger.getTrainNo());
		*/
		ticket.setPassenger(passenger);
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		//decimalFormat.setMaximumFractionDigits(2);
		//decimalFormat.setMinimumFractionDigits(2);
		float fare = new Random().nextFloat(1000,2000);
		fare = Float.parseFloat(String.format("%.2f",fare));
		ticket.setTicketFare(fare);
		
		LocalDate date = LocalDate.now();
		ticket.setDateOfBooking(date);
		
		List<String> ticketStatusData = Arrays.asList("CNF","RLWL","WL","RAC");
		String ticketStatus = ticketStatusData.get(new Random().nextInt(ticketStatusData.size()));
		ticket.setBookingStatus(ticketStatus);
		
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
