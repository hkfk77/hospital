package com.zhiyou100.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.RegistrationMapper;
import com.zhiyou100.model.RegistrationInfor;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationMapper mapper;

	@Override
	public List<RegistrationInfor> findAllRegistration(Map<Object, Object> map) {
		List<RegistrationInfor> rInfors = mapper.findAllRegistration(map);
		return rInfors;
	}

	@Override
	public RegistrationInfor findRegistrationById(String medical_record) {
		RegistrationInfor rInfor = mapper.findRegistrationById(medical_record);
		return rInfor;
	}

	@Override
	public void updateRegistration(RegistrationInfor registrationInfor) {
		mapper.updateRegistration(registrationInfor);
	}

	@Override
	public void deleteRegistration(String medical_record, String status) {
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("status", status);
		mapper.deleteRegistration(map);
	}

	@Override
	public void addRegistration(RegistrationInfor registrationInfor) {
		mapper.addRegistration(registrationInfor);
	}
	

	
}
