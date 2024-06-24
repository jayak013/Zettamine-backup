package com.zettamine.data.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class DataProvider2 implements DataProvider {

	@Override
	public int[] getData() {
		return new int[]{-45,-25,-63,-12,-8,-62};
	}

}
