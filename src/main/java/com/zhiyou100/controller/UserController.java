package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	@RequestMapping("/list.do")
	public String findAllUser(String username,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		PageHelper.startPage(pageNo, 3);
		List<User> users = service.findAllUser(map);
		PageInfo<User> pageInfo = new PageInfo<>(users);
		request.setAttribute("users", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "User/index";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public String editSkip(int id,HttpServletRequest request) {
		User user = service.findUserById(id);
//		System.out.println(user);
		request.setAttribute("u", user);
		return "User/editUser";	
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String editUser(User user,int role_num) {
//		System.out.println(user);
		Integer role_name = role_num;
//		System.out.println(role_name);
		Integer id = user.getId();
		Map<String,Integer> map = new HashMap<>(); 
		map.put("role_name", role_name);
		map.put("id", id);
		service.editRole(map);
		service.editUser(user);
		return "forward:/user/list.do";	
	}
	
	@RequestMapping("/delete.do")
	public String deleteUser(int id) {
		service.deleteUserById(id);
		return "forward:/user/list.do";
		
	}
	
	@RequestMapping("/add.do")
	public String addSkip() {
		
		return "User/addUser";
	}
	
	@RequestMapping("/insert.do")
	public String addUser(User user,int role_id) {
		Map<String,Integer> map = new HashMap<>(); 
		map.put("role_id", role_id);
		service.insertUser(user);
		Integer id = user.getId();
		System.out.println(id);
		map.put("id", id);
		service.insetUserRole(map);
		return "forward:/user/list.do";
	}
	
	@RequestMapping("/updatePassword.do")
	public String updatePassword(HttpSession session,HttpServletRequest request) {
		Object user = session.getAttribute("user");
		request.setAttribute("u", user);
//		System.out.println(user); 
		return "User/updatePassword";
	}
	
	@RequestMapping("/editPassword.do")
	public String updatePassword(User user,HttpSession session) {
		service.updatePassword(user);
		session.invalidate();
		return "forward:/login.jsp"; 
	}
}
