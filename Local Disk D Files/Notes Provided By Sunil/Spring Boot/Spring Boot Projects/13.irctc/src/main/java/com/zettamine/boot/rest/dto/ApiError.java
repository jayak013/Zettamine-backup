package com.zettamine.boot.rest.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class ApiError {
	private String erroMessage;
	private String errorDate;
	private String errorType;
}
