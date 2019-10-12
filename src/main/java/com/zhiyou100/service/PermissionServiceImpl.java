package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.PermissionMapper;
import com.zhiyou100.model.Permission;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper mapper;

	@Override
	public List<Permission> findAllPermission(Map<String, String> map) {
		return mapper.findAllPermission(map);
	}

	@Override
	public void deletePermissionById(int id) {
		mapper.deletePermissionById(id);
	}

	@Override
	public Permission findPermissionById(int id) {
		
		return mapper.findPermissionById(id);
	}

	@Override
	public void editPermission(Permission permission) {
		mapper.editPermission(permission);
	}

	@Override
	public void insertPermission(Permission permission) {
		mapper.insertPermission(permission);
	}
	
	
	
}
