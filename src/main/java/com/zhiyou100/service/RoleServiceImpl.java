package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.RoleMapper;
import com.zhiyou100.model.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper mapper;

	@Override
	public List<Role> findAllRole(Map<String, String> map) {
		
		return mapper.findAllRole(map);
	}

	@Override
	public void deleteRole(int id) {
		mapper.deleteRole(id);
	}

	@Override
	public Role findRoleById(int id) {
		
		return mapper.findRoleById(id);
	}

	@Override
	public void addRole(Role role) {
		mapper.addRole(role);
	}

	@Override
	public void addRolePermission(Map<String, Integer> map) {
		mapper.addRolePermission(map);
	}
	
}
