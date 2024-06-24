package com.zettamine.boot.rest.email.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Email {
	
	private String toMail;
	private String subject;
	private String body;
	
}
