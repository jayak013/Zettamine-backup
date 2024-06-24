package com.excp;
import java.lang.Enum;
public enum CountryISOCodes {
	
	//name-value / key value pairs
	
	AF("Afganistan"),
	BE("Belgium"),
	CA("Canada"),
	IN("India"),
	LK("Sri Lanka"),
	JP("Japan"),
	ZW("Zimbabwe");
	
	
	
	private final String displayValue;
	
	private CountryISOCodes(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public static String getValue(String name) {
		String value = null;
		for(CountryISOCodes code : CountryISOCodes.values()) {
			if(code.name().equals(name)) {
				value = code.displayValue;
				break;
			}
		}
		return value;
	}
	
	public static boolean contains(String name) {
		for(CountryISOCodes code : CountryISOCodes.values()) 
			if(code.name().equals(name)) return true;
				return false;
	}
	
}
