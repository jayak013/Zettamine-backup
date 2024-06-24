package com.zettamine.materialinspection.model;

public enum MaterialCharacteristics {
	
	OUTER_DIAMETER("OUTER DIAMTER"),
	INNER_DIAMETER("INNER DIAMETER"),
	THICKNESS("THICKNESS"),
	LENGTH("LENGTH"),
	WEIGHT("WEIGHT");
	
	
	public String chars;
	private MaterialCharacteristics(String chars) {
		this.chars = chars;
	}
	
}
