package com.zettamine.login.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "f_name")
	private String firstName;
	
	@Column(name = "pwd")
	private String password;
	
	@Column(name = "temp_pwd")
	private String tempPwd;
	
	@Column(name = "l_name")
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "login_status")
	private Integer loginStatus;
	
	@Column(name ="acc_lock")
	private Boolean accountLock;
	
	@Column(name = "attempts")
	private Integer attempts;
	
	@Column(name = "otp")
	private Integer otp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;
	
}
