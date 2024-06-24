package com.zettamine.materialinspection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.materialinspection.entities.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	
	
	User findByUserNameAndPassword(String username,String password);
}
