package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.User;

public interface UserMapper {

	List<User> findAllUser(Map<String, String> map);

	User findUserById(int id);

	void editRole(Map<String, Integer> map);

	void editUser(User user);

	void deleteUserById(int id);

	void insertUser(User user);

	void insetUserRole(Map<String, Integer> map);

	void updatePassword(User user);


}
