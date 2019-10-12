package com.zhiyou100.service;

import com.zhiyou100.model.User;

public interface LoginService {

	User login(String user_name, String password);

	String findJurisdiction(String user_name, String password);


}
