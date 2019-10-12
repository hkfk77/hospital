package com.zhiyou100.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping("login.do")
	public String Login(
			String user_name,
			String password,
			HttpServletRequest request) {
		User user = service.login(user_name,password);
		String Jurisdiction = service.findJurisdiction(user_name,password);
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("J", Jurisdiction);
			session.setAttribute("user", user);
			return "forward:/index.jsp";
		} else {
			request.setAttribute("massage", "账号或密码错误");
			return "forward:/login.jsp";
		}
	}
}
