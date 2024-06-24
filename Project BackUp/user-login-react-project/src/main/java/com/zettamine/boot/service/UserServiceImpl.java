package com.zettamine.boot.service;


import org.passay.CharacterRule;

import java.util.Optional;

import org.passay.CharacterData;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

import com.zettamine.boot.dto.UserDto;
import com.zettamine.boot.email.EmailService;
import com.zettamine.boot.entity.User;
import com.zettamine.boot.exception.ResounceAlreadyExistsException;
import com.zettamine.boot.mapper.UserMapper;
import com.zettamine.boot.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

	private UserRepository repository;
	
	private IRoleService roleService;
	
	private EmailService emailService;
	
	@Override
	@Transactional
	public void save(UserDto userDto) {
		
		Optional<User> optUser = repository.findByEmail(userDto.getEmail());
		if (optUser.isPresent()) {
			throw new ResounceAlreadyExistsException("User is already exists with this email: "+userDto.getEmail());
		}
		User user = UserMapper.userDtoToUser(userDto, new User());
		user.setTempPwd(generatePassayPassword());
		user.setAccountLock(false);
		user.setLoginStatus(0);
		user.setAttempts(0);
		user.setRole(roleService.getByRoleId(userDto.getRoleId()));
		

		 try {
	            if (!emailService.sendEmail(user)) {
	            	throw new RuntimeException("Failed to send email or save user try");
				}
	            repository.save(user);
	        } catch (Exception e) {
	            log.error("Failed to send email or save user: {}", e.getMessage());
	            throw new RuntimeException("Failed to send email or save user", e);
	        }
	}

	private static String generatePassayPassword() {

		PasswordGenerator gen = new PasswordGenerator();
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return "cannot generate special characters";
			}

			public String getCharacters() {
				return "!@#$%^&*()_+";
			}
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(2);

		String password = gen.generatePassword(10, splCharRule, lowerCaseRule, upperCaseRule, digitRule);

		return password;
	}
}
