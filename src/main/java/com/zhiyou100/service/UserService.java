package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.User;

public interface UserService {

	List<User> findAllUser(Map<String, String> map);

	User findUserById(int id);

	void editRole(Map<String, Integer> map);

	void editUser(User user);

	void deleteUserById(int id);

	void insertUser(User user);

	void insetUserRole(Map<String, Integer> map);

	void updatePassword(User user);

}
