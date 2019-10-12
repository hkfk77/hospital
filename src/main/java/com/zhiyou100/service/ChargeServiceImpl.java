package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ChargeMapper;
import com.zhiyou100.model.ChargeManager;

@Service
public class ChargeServiceImpl implements ChargeService{
	
	@Autowired()
	private ChargeMapper mapper;

	@Override
	public List<ChargeManager> findAllCharge(Map<String, String> map) {
		
		return mapper.findAllCharge(map);
	}

	@Override
	public ChargeManager findCharge(String medical_record) {
		
		return mapper.findCharge(medical_record);
	}

	@Override
	public void addCharge(ChargeManager chargeManager) {
		mapper.addCharge(chargeManager);
	}
	
}
