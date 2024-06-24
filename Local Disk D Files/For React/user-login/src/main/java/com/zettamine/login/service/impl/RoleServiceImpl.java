package com.zettamine.login.service.impl;

import org.springframework.stereotype.Service;

import com.zettamine.login.dto.RoleDto;
import com.zettamine.login.entity.Role;
import com.zettamine.login.exception.ResourceNotFoundException;
import com.zettamine.login.mapper.RoleMapper;
import com.zettamine.login.repository.RoleRepository;
import com.zettamine.login.service.IRoleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService{
	
private RoleRepository repository;
	
	@Override
	public void saveRole(RoleDto roleDto) {
		Role role = RoleMapper.roleDtoToRole(roleDto, new Role());
		repository.save(role);
	}

	@Override
	public Role getByRoleId(Integer roleId) {
		Role role = repository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "role Id", roleId.toString()));
		return role;
	}

	
}
