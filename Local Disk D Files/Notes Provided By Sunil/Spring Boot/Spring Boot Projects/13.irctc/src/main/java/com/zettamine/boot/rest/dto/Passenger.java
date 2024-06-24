package com.zettamine.boot.rest.dto;

import java.time.LocalDate;

import com.zettamine.boot.rest.dto.adapter.LocalDateAdapter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
@Schema(
        name = "Passenger",
        description = "Schema to hold passenger information")
public class Passenger {
	@NotBlank(message = "* required")
	@Schema(description = "Name of the passenger", example = "Sunil Joseph" )
	private String passengerName;

	@Size(min = 3)
	@Schema(description = "fromStation of travel, min 3 chars", example = "Hyderabad" )
	private String fromStation;
	
	@Size(min = 3)
	private String toStation;
	
	@NotNull
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJourney;
	
	@Size(min = 5, max = 6)
	private String trainNo;
}
