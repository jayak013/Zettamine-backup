package com.zettamine.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RoleDto {

	private Integer roleId;
	
	private String roleName;
	
	private String roleDesc;
}
