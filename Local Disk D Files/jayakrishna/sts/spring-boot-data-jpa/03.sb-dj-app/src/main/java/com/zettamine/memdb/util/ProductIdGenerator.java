package com.zettamine.memdb.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator {
	
	private static int pid = 101;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		return "PD_"+(pid++);
	}

}
