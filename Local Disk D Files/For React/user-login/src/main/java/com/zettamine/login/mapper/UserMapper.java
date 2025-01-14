package com.zettamine.login.mapper;

import com.zettamine.login.dto.UserDto;
import com.zettamine.login.entity.User;

public class UserMapper {
	
	public static User userDtoToUser( UserDto userDto,User user) {
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setDesignation(userDto.getDesignation());
		return user;
	}
	
	public static UserDto userToUserDto(User user,UserDto userDto) {
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setDesignation(user.getDesignation());
		userDto.setRoleId(user.getRole().getRoleId());
		userDto.setAccountEnabled(user.getAccountLock());
		userDto.setLoginStatus(user.getLoginStatus());
		userDto.setOtp(user.getOtp());
		userDto.setId(user.getUserId());
		return userDto;
	}
	
}
