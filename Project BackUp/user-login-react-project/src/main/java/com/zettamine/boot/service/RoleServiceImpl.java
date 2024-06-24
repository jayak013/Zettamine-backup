package com.zettamine.boot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.boot.dto.RoleDto;
import com.zettamine.boot.entity.Role;
import com.zettamine.boot.exception.ResourceNotFoundException;
import com.zettamine.boot.mapper.RoleMapper;
import com.zettamine.boot.repository.RoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {

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
