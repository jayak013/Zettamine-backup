package com.zettamine.login.service;

import com.zettamine.login.dto.RoleDto;
import com.zettamine.login.entity.Role;

public interface IRoleService {
	
	public void saveRole(RoleDto roleDto);

	public Role getByRoleId(Integer roleId);
	
}
