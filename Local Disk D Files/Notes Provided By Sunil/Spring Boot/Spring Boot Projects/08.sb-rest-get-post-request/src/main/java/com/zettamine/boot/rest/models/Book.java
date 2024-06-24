package com.zettamine.boot.rest.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Book {
	private Integer bookId;
	private String bookTitle;
	private Float bookPrice;
}
