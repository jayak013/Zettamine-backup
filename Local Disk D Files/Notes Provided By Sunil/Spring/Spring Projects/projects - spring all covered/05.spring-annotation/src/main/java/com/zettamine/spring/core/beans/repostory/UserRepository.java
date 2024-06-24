package com.zettamine.spring.core.beans.repostory;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public UserRepository() {
		System.out.println("UserRepository :: Constructor");
	}

}
