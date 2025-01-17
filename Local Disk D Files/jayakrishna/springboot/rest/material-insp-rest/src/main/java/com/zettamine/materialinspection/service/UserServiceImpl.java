package com.zettamine.materialinspection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.materialinspection.entities.User;
import com.zettamine.materialinspection.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User getByUserNameAndPassword(String username, String password) {
		return userRepo.findByUserNameAndPassword(username, password);
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

}
