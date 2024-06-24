package com.zettamine.login.mapper;

import com.zettamine.login.dto.RoleDto;
import com.zettamine.login.entity.Role;

public class RoleMapper {

	public static Role roleDtoToRole(RoleDto dto, Role role) {
		role.setRoleId(dto.getRoleId());
		role.setRoleName(dto.getRoleName());
		role.setRoleDesc(dto.getRoleDesc());
		return role;
	}
	
	public static RoleDto roleToRoleDto(Role role, RoleDto dto) {
		dto.setRoleId(role.getRoleId());
		dto.setRoleName(role.getRoleName());
		dto.setRoleDesc(role.getRoleDesc());
		return dto;
	}
	
}
