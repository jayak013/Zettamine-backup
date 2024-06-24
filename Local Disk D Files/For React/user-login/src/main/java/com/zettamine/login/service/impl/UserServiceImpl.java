package com.zettamine.login.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Service;

import com.zettamine.login.dto.UserDto;
import com.zettamine.login.dto.ValidateUserDto;
import com.zettamine.login.email.EmailService;
import com.zettamine.login.entity.User;
import com.zettamine.login.exception.ResourceAlreadyExistsException;
import com.zettamine.login.exception.ResourceNotFoundException;
import com.zettamine.login.mapper.UserMapper;
import com.zettamine.login.repository.UserRepository;
import com.zettamine.login.service.IRoleService;
import com.zettamine.login.service.IUserService;
import com.zettamine.login.util.UserUtils;

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
	public void addUser(UserDto userDto) {
		
		Optional<User> optUser = repository.findByEmail(userDto.getEmail());
		if (optUser.isPresent()) {
			throw new ResourceAlreadyExistsException("User is already exists with this email: "+userDto.getEmail());
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
		repository.save(user);
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

	@Override
	public UserDto validateUser(ValidateUserDto userDto) {
		
		Optional<User> userOptObj = repository.findByEmail(userDto.getEmail());
		if(userOptObj.isPresent() && userOptObj.get().getLoginStatus()==0 
				&& userDto.getPassword().equals(userOptObj.get().getTempPwd())) {
			User user = userOptObj.get();
			user.setAttempts(0);
			repository.save(user);
			return UserMapper.userToUserDto(user, new UserDto());
		}else if(userOptObj.isPresent() && userOptObj.get().getLoginStatus()==1 
				&& userDto.getPassword().equals(userOptObj.get().getPassword())) {
			User user = userOptObj.get();
			user.setAttempts(0);
			repository.save(user);
			return UserMapper.userToUserDto(user, new UserDto());
		}
		throw new ResourceNotFoundException("User","email and password",userDto.getEmail()+","+userDto.getPassword());
	}

	@Override
	public UserDto isValidEmail(String email) {
		Optional<User> userOptObj = repository.findByEmail(email);
		if(userOptObj.isPresent()) {
			User user = userOptObj.get();
			UserDto userDtoObj = UserMapper.userToUserDto(user, new UserDto());
			return userDtoObj;
		}
		throw new ResourceNotFoundException("User","email",email);
	}

	@Override
	public void updateLoginAttempts(String email) {
		Optional<User> optUser = repository.findByEmail(email);
		if(optUser.isPresent()) {
			User user = optUser.get();
			user.setAttempts(5);
			user.setAccountLock(true);
			repository.save(user);
		}
	}

	@Override
	public void updatePassword(ValidateUserDto userDto) {
		System.out.println(userDto);
		Optional<User> optUser = repository.findByEmail(userDto.getEmail());
		if(optUser.isEmpty()) throw new ResourceNotFoundException("email", "user", userDto.getEmail());
		if(optUser.isPresent()) {
			User user = optUser.get();
			if(user.getOtp()!=null) {
				user.setPassword(userDto.getPassword());
				user.setOtp(null);
				repository.save(user);
			}else if(userDto.getNewPassword()==null){
				user.setPassword(userDto.getPassword());
				user.setLoginStatus(1);
				repository.save(user);
			}else {
				if(!user.getPassword().equals(userDto.getPassword())) throw new RuntimeException("Password does not match");
				user.setPassword(userDto.getNewPassword());
				repository.save(user);
			}
		}
	}
//
//	@Override
//	public void forgotPassword(String email) {
//		Optional<User> optUser = repository.findByEmail(email);
//		if(optUser.isEmpty()) throw new ResourceNotFoundException("email", "user", email);
//		if(optUser.isPresent()) {
//			User user = optUser.get();
//			user.setTempPwd(generatePassayPassword());
//			user.setLoginStatus(0);
//			user.setAttempts(0);
//			user.setAccountLock(false);
//			 try {
//            if (!emailService.sendEmail(user)) {
//            	throw new RuntimeException("Failed to send email or save user try");
//			}
//            repository.save(user);
//        } catch (Exception e) {
//            log.error("Failed to send email or save user: {}", e.getMessage());
//            throw new RuntimeException("Failed to send email or save user", e);
//        }
//		}
//	}

	@Override
	public UserDto sendOtp(String email) {
		Optional<User> optUser = repository.findByEmail(email);
		if(optUser.isEmpty()) throw new ResourceNotFoundException("email", "user", email);
		if(optUser.isPresent()) {
			User user = optUser.get();
			Integer otp = UserUtils.createOTP();
			user.setOtp(otp);
			user.setAttempts(0);
			user.setAccountLock(false);
			 try {
            if (!emailService.sendEmail(user)) {
            	throw new RuntimeException("Failed to send email or save user try");
			}
            User save = repository.save(user);
            return UserMapper.userToUserDto(save, new UserDto());
        } catch (Exception e) {
            log.error("Failed to send email or save user: {}", e.getMessage());
            throw new RuntimeException("Failed to send email or save user", e);
        }
		}
		return null;
	}

	@Override
	public void forgotPassword(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDto> getAll() {
		List<User> all = repository.findAll();
		List<UserDto> collect = all.stream().map(u->UserMapper.userToUserDto(u, new UserDto())).collect(Collectors.toList());
		return collect;
	}
}

