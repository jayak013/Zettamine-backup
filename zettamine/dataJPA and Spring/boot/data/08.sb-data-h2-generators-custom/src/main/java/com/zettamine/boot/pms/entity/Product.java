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
	@GeneratedValue(generator = "pid_gen")
	@GenericGenerator(name = "pid_gen", strategy = "com.zettamine.boot.pms.entity.generators.ProductIdGenerator")
	private String productId;
	private String productName;
	private Float productPrice;
	
	public Product() {	}
	
	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
}
