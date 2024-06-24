package com.zettamine.boot.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
}
