package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.AccountMapper;
import com.zhiyou100.model.HospitalClear;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	public AccountMapper mapper;

	@Override
	public List<HospitalClear> findAllAccount(Map<String, String> map) {
		return mapper.findAllAccount(map);
	}

	@Override
	public HospitalClear detailAccount(int id) {
		// TODO Auto-generated method stub
		return mapper.detailAccount(id);
	}

	@Override
	public void updateHospitalClear(Map<String, Object> map) {
		mapper.updateHospitalClear(map);
	}
	
}
