package com.zettamine.hibernate.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDR_ID")
	private Integer addressId;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Employee employee;

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
