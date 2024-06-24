package com.wipro.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DataProvider1 implements DataProvider {

	@Override
	public int[] getData() {
		return new int[]{45,25,63,12,8,62};
	}

}
