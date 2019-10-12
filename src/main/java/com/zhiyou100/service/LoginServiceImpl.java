package com.zhiyou100.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.LoginMapper;
import com.zhiyou100.model.User;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper mapper;
	
	@Override
	public User login(String user_name, String password) {
		Map<String,String> map = new HashMap<>();
		
		map.put("user_name", user_name);
		map.put("password",password);
		User user = mapper.login(map);
		return user;
	}

	@Override
	public String findJurisdiction(String user_name, String password) {
		Map<String,String> map = new HashMap<>();
		map.put("user_name", user_name);
		map.put("password",password);
		String Jurisdiction = mapper.findJurisdiction(map);
		return Jurisdiction;
	}
	
}
