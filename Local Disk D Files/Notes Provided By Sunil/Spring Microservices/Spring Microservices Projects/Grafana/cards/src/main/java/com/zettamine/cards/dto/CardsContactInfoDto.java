package com.zettamine.cards.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "cards")
@Data
@Component
public class CardsContactInfoDto {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;

}
