package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Permission;

public interface PermissionService {

	List<Permission> findAllPermission(Map<String, String> map);

	void deletePermissionById(int id);

	Permission findPermissionById(int id);

	void editPermission(Permission permission);

	void insertPermission(Permission permission);

}
