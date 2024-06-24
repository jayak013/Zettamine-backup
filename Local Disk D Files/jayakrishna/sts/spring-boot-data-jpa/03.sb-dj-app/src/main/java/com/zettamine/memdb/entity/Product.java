package com.zettamine.memdb.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "product_master")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Product.getAllProducts",query = "from Product")
public class Product {
	@Id
	@GeneratedValue(generator = "pid_gen")
	@GenericGenerator(name = "pid_gen",strategy = "com.zettamine.memdb.util.ProductIdGenerator")
	private String productId;
	@NonNull
	private String productName;
	@NonNull
	private Integer productPrice;
	
	
}
