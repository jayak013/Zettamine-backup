package com.zettamine.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Integer id;
	
	@NotEmpty(message = "First Name should not be empty")
	private String firstName;
	
	@NotEmpty(message = "Last Name should not be empty")
	private String lastName;
	
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email Should be a valid one")
	private String email;
	
	@NotEmpty(message = "Email should not be empty")
	private String Designation;
	
	private Integer roleId;
	
	private Boolean accountEnabled;
	
	private Integer loginStatus;
	
	private Integer otp;	
}
