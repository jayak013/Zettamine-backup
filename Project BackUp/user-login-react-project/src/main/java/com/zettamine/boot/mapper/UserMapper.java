package com.zettamine.boot.mapper;

import com.zettamine.boot.dto.UserDto;
import com.zettamine.boot.entity.User;

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
		return userDto;
	}
}
