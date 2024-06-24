package com.zettamine.loans.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@ConfigurationProperties(prefix = "loans")
public class LoansContactInfoDto {
	String message;
	Map<String, String> contactDetails; 
	List<String> onCallSupport; 
}
