package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> findAllUser(Map<String, String> map) {
		
		return mapper.findAllUser(map);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return mapper.findUserById(id);
	}

	@Override
	public void editRole(Map<String, Integer> map) {
		mapper.editRole(map);
	}

	@Override
	public void editUser(User user) {
		mapper.editUser(user);
	}

	@Override
	public void deleteUserById(int id) {
		mapper.deleteUserById(id);
	}

	@Override
	public void insertUser(User user) {
		mapper.insertUser(user);
	}

	@Override
	public void insetUserRole(Map<String, Integer> map) {
		mapper.insetUserRole(map);
	}

	@Override
	public void updatePassword(User user) {
		mapper.updatePassword(user);
	}
	
	
}
