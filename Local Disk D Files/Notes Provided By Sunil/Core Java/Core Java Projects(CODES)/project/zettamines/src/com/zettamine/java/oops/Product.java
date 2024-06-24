package com.zettamine.java.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
*/
@Data
public class Product {
	private Long productId;
	private String productName;
	private Float productPrice;
}
