package com.zettamine.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Data
@RequiredArgsConstructor
public class Address {
	@Id
	@Column(name = "ADDR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	private String street;
	private String city;
	private String state;

	public Address(String street, String city, String state) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
	}

}
