package com.zettamine.boot.service;

import com.zettamine.boot.dto.RoleDto;
import com.zettamine.boot.entity.Role;

public interface IRoleService {

	void saveRole(RoleDto roleDto);
	
	Role getByRoleId(Integer roleId);
}
