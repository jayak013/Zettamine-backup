package com.zettamine.boot.rest.entities;



import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Ticket {
	
	private Integer pnr;
	private String passengerName;
	private Date dateOfBooking;
	private Double fare;
	private String ticketStatus;
	private Date dateOfJourney;
	private String fromStation;
	private String toStation;
	
}
