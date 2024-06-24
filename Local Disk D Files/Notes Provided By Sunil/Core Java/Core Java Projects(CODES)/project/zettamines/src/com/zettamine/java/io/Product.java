package com.zettamine.java.io;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private Integer productId;
	private String productName;
}
