package com.zettamine.boot.rest.entities;




import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
	
	private String passengerName;
	private Integer trainNo;
	private String fromStation;
	private String toStation;
	private Date dateOfJourney;
	private Double fare;
	
}
