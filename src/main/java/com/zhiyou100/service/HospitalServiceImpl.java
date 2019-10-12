package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.HospitalMapper;
import com.zhiyou100.model.HospitalInfor;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalMapper mapper;

	@Override
	public List<HospitalInfor> findAllHospital(Map<String, String> map) {
		return mapper.findAllHospital(map);
	}

	@Override
	public HospitalInfor findHospitalById(String medical_record) {
		
		return mapper.findHospitalById(medical_record);
	}

	@Override
	public void insertHospital(HospitalInfor hospitalInfor) {
		mapper.insertHospital(hospitalInfor);
	}

	@Override
	public void updateHospitalById(HospitalInfor hospitalInfor) {
		mapper.updateHospitalById(hospitalInfor);
	}

	@Override
	public HospitalInfor findHospitalOneById(String medical_record) {
		return mapper.findHospitalOneById(medical_record);
	}

	@Override
	public void dischargeHospitalByid(Map<String, String> map) {
		mapper.dischargeHospitalByid(map);
	}

	@Override
	public void leaveHospitalByid(Map<String, String> map) {
		mapper.leaveHospitalByid(map);
	}
	
}
