package com.zettamine.login.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.login.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable>{
	
	Optional<User>findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email,String Password);
	
	Optional<User> findByEmailAndTempPwd(String email,String Password);
	
}
