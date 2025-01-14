package com.zettamine.login.service;

import java.util.List;

import com.zettamine.login.dto.UserDto;
import com.zettamine.login.dto.ValidateUserDto;
import com.zettamine.login.entity.User;


public interface IUserService {
	
	void addUser(UserDto userDto);

	UserDto validateUser(ValidateUserDto userDto);

	UserDto isValidEmail(String email);

	void updateLoginAttempts(String email);
	
	void updatePassword(ValidateUserDto userDto);

	void forgotPassword(String email);

	UserDto sendOtp(String email);

	List<UserDto> getAll();
}
