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
import com.zhiyou100.model.Permission;
import com.zhiyou100.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService service;
	
	@RequestMapping("/list.do")
	public String findAllPermission(
			String resource_name,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		Map <String,String> map = new HashMap<>();
		map.put("resource_name", resource_name);
		PageHelper.startPage(pageNo, 2);
		List<Permission> permission = service.findAllPermission(map);
		PageInfo<Permission> pageInfo = new PageInfo<>(permission);
		request.setAttribute("permission", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "Resource/index";
	}
	
	@RequestMapping("/delete")
	public String deletePermission(int id) {
		service.deletePermissionById(id);
		return "forward:/permission/list.do";
		
	}
	
	@RequestMapping("/edit.do")
	public String editSkip(int id,
			HttpServletRequest request) {
		
		Permission permission = service.findPermissionById(id);
		request.setAttribute("p", permission);
		return "Resource/edit";
		
	}
	
	@RequestMapping("/update.do")
	public String eidtPermission(Permission permission) {
		System.out.println("-----"+permission);
		service.editPermission(permission);
		return "forward:/permission/list.do";
		
	}
	
	@RequestMapping("/add.do")
	public String addPermissionSkip() {
		return "Resource/add";
	}
	@RequestMapping("/insert.do")
	public String addPermission(Permission permission) {
		service.insertPermission(permission);
		return "forward:/permission/list.do";
	}
	
}
