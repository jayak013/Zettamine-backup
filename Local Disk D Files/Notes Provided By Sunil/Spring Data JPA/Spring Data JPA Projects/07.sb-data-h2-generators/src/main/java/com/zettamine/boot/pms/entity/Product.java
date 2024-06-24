package com.zettamine.boot.pms.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	//@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_generator")
	@SequenceGenerator(name = "pid_generator", sequenceName = "prod_sequence", initialValue = 101, allocationSize = 1)
	private Integer productId;
	private String productName;
	private Float productPrice;
	
	public Product() {	}
	
	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
