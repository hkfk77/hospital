package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Role;
import com.zhiyou100.model.RolePermission;
import com.zhiyou100.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@RequestMapping("/list.do")
	public String findAllRole(
			String role_name,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		map.put("role_name", role_name);
		PageHelper.startPage(pageNo, 2);
		List<Role> roles = service.findAllRole(map);
		PageInfo<Role> pageInfo = new PageInfo<>(roles);
		request.setAttribute("roles", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "Role/index";
	}
	
	@RequestMapping("/delete.do")
	public String deleteRole(int id) {
		service.deleteRole(id);
		return "forward:/role/list.do";
	}
	
	@RequestMapping("/edit.do")
	public String editRole(int id,HttpServletRequest request) {
		
		Role role = service.findRoleById(id);
		request.setAttribute("r", role);
		return "Role/editRole";
	}
	
	@RequestMapping("/add.do")
	public String addRole() {
		return "Role/addRole";
	}
	@RequestMapping("/insert.do")
	public String addRole(Role role,int[] permission) {
		service.addRole(role);
		Map<String,Integer> map = new HashMap<>();
		Integer id = role.getId();
		map.put("id", id);
		for (int i : permission) {
			map.put("permission_id", i);
			service.addRolePermission(map);
			map.remove("permission_id");
		}
		
		return "forward:/role/list.do";
		
	}
}
