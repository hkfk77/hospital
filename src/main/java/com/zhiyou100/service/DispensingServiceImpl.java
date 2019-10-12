package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DispensingMapper;
import com.zhiyou100.model.Dispensing;

@Service
public class DispensingServiceImpl implements DispensingService{
	
	@Autowired
	private DispensingMapper mapper;

	@Override
	public List<Dispensing> findAllDispensing(Map<String, String> map) {
		
		return mapper.findAllDispensing(map);
	}

	@Override
	public Dispensing dispensingGive(String medical_record) {
		
		return mapper.dispensingGive(medical_record);
	}

	@Override
	public void updateDispensing(Map<String, Object> map) {
		mapper.updateDispensing(map);
	}

	@Override
	public Dispensing dispensingDetail(String medical_record) {
		
		return mapper.dispensingDetail(medical_record);
	}

	@Override
	public void updateNum(Dispensing dispensing) {
		mapper.updateNum(dispensing);
	}

	@Override
	public void updateOne(Dispensing dispensing) {
		mapper.updateOne(dispensing);
	}

	@Override
	public void updateFive(Dispensing dispensing) {
		mapper.updateFive(dispensing);
	}

	@Override
	public void updateDelive(Dispensing dispensing) {
		mapper.updateDelive(dispensing);
	}
	
	
	
}
