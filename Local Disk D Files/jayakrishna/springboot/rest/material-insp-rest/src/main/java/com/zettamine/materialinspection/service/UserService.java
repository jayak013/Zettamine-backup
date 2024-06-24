package com.zettamine.materialinspection.service;

import com.zettamine.materialinspection.entities.User;

public interface UserService {
	User getByUserNameAndPassword(String username,String password);
	
	User addUser(User user);
}
