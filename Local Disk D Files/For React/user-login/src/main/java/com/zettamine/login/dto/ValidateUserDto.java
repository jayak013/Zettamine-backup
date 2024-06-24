package com.zettamine.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateUserDto {
	
	private String email;
	private String password;
	private Integer otp;
	private String newPassword;
	
}
