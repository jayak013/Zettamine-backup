package com.zettamine.data.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zettamine.data.dao.DataProvider;

@Service
public class DataServices {
	@Autowired
	@Qualifier("dataProvider1")
	private DataProvider dataProvider;
	
	public int findMax() {
		int[] data = dataProvider.getData();
		int max = Arrays.stream(data).max().getAsInt();
		return max;
	}
}
