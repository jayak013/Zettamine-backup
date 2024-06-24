package com.wipro.spring.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.spring.dao.DataProvider;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
//@Service
@Named
public class DataService {
	//@Autowired
	@Inject
	@Qualifier("dataProvider1")
	private DataProvider dProvider;
	
	public int findMax() {
		int[] data =dProvider.getData();
		System.out.println("data is ---> "+ Arrays.toString(data));
		
		int maxValue = Arrays.stream(data).max().orElse(0);
		return maxValue;
	}
}
