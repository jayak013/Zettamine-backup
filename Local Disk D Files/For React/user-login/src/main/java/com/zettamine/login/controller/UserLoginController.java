package com.zettamine.login.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.login.constants.AppConstants;
import com.zettamine.login.dto.ResponseDto;
import com.zettamine.login.dto.UserDto;
import com.zettamine.login.dto.ValidateUserDto;
import com.zettamine.login.service.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
@CrossOrigin
public class UserLoginController {

	private IUserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto){
		userService.addUser(userDto);
		return ResponseEntity 
				.status(HttpStatus.CREATED)
				.body( new ResponseDto(AppConstants.STATUS_201,AppConstants.MESSAGE_201));
	}	
	
	@PostMapping("/validate")
	public ResponseEntity<UserDto> validateUser(@RequestBody ValidateUserDto userDto){
		UserDto userDtoObj = userService.validateUser(userDto);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body( userDtoObj);
	}
	
	@GetMapping("/valid-email")
	public ResponseEntity<UserDto> validateUser(@RequestParam String email){
		UserDto userDto = userService.isValidEmail(email);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body( userDto);
	}
	
	@GetMapping("/update-login-attempts")
	public ResponseEntity<ResponseDto> updateLoginAttempts(@RequestParam String email){
		userService.updateLoginAttempts(email);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body( new ResponseDto(AppConstants.STATUS_200,AppConstants.MESSAGE_200));
	}
	
	@PostMapping("/forgot-password/{email}")
	public ResponseEntity<ResponseDto> updatePassword(@PathVariable String email){
		userService.forgotPassword(email);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body(new ResponseDto(AppConstants.STATUS_200,AppConstants.MESSAGE_200));
	}
	@PutMapping("/change-password")
	public ResponseEntity<ResponseDto> updatePassword(@RequestBody ValidateUserDto userDto){
		userService.updatePassword(userDto);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body(new ResponseDto(AppConstants.STATUS_200,AppConstants.MESSAGE_200));
	}
	
	@PutMapping("/reset-password")
	public ResponseEntity<ResponseDto> resetPassword(@RequestBody ValidateUserDto userDto){
		userService.updatePassword(userDto);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body(new ResponseDto(AppConstants.STATUS_200,AppConstants.MESSAGE_200));
	}
	
	@PutMapping("/send-otp/{email}")
	public ResponseEntity<UserDto> sendOtp(@PathVariable String email){
		UserDto userDto = userService.sendOtp(email);
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body(userDto);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> fetchAll(){
		List<UserDto> listOfUserDto = userService.getAll();
		return ResponseEntity 
				.status(HttpStatus.OK)
				.body( listOfUserDto);
	}
}
