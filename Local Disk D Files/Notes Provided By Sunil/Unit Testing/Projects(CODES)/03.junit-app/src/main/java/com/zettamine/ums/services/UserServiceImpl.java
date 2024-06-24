package com.zettamine.ums.services;

import java.util.concurrent.TimeUnit;

public class UserServiceImpl implements UserService {

	@Override
	public String findUserNameById(int id) {
		// logic to get userName from DB
		try {
			System.out.println("working with DAO layer.....");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("got response...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (id > 100)
			return "Sanjay";

		return null;
	}

}
