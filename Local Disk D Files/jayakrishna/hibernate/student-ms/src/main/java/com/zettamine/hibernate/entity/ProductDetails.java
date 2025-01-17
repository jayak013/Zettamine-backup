package com.zettamine.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROD_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pid_generator")
	@SequenceGenerator(name = "pid_generator",sequenceName = "prod_sequence",initialValue = 101,allocationSize = 1)
	@Column(name = "prod_id")
	private int productId;
	
	@Column(name = "prod_name")
	private String productName;
	
	@Column(name = "prod_price")
	private double productPrice;
}
