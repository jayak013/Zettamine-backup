package com.zettamine.materialinspection.utils;

import org.springframework.stereotype.Component;

@Component
public class SpaceRemover {
	
	public String removeSpaces(String s) {
		return s.replaceAll(" ", "");
	}
	
}
