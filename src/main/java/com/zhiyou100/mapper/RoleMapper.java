package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Role;

public interface RoleMapper {

	List<Role> findAllRole(Map<String, String> map);

	void deleteRole(int id);

	Role findRoleById(int id);

	void addRole(Role role);

	void addRolePermission(Map<String, Integer> map);

}
