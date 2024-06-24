package com.zettamine.ums.dao;

import java.util.List;

import com.zettamine.ums.dto.User;

public interface UserDAO {
	 void addUser(User user);
	 void deleteUserById(int userId);
	 void updateUser(User user);
	 List<User> getAllUsers();
	 User findUserById(int userId);

}
