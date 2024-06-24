package com.zettamine.login.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.login.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>{

}
