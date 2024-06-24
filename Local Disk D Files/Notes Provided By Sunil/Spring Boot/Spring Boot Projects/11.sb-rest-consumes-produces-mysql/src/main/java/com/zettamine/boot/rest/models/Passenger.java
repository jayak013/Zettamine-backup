package com.zettamine.boot.rest.models;

import java.time.LocalDate;

import com.zettamine.boot.rest.models.adapter.LocalDateAdapter;

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
public class Passenger {
	@NotBlank(message = "* required")
	private String passengerName;

	@Size(min = 3)
	private String fromStation;
	
	@Size(min = 3)
	private String toStation;
	
	@NotNull
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJourney;
	
	@Size(min = 5, max = 6)
	private String trainNo;
}
