package com.zettamine.bootjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "customer_master")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

	
	@Column(name = "cust_id")
	@Id
	private Integer customerId;
	
	@Column(name = "cust_name")
	private String customerName;
	
	@Column(name = "cust_num")
	private String customerNumber;

	@Override
	public String toString() {
		return String.format("[ %-3d | %-15s | %-10s ]\n",customerId,customerName,customerNumber);
	}
	
	
	
}
