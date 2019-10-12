package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DrugMapper;
import com.zhiyou100.model.Drug;

@Service
public class DrugServiceImpl implements DrugService{

	@Autowired
	private DrugMapper mapper;

	@Override
	public List<Drug> findAllDrug(Map<String, String> map) {
		List<Drug> drugs = mapper.findAllDrug(map);
		return drugs;
	}

	@Override
	public void addDrug(Drug drug) {
		mapper.addDrug(drug);
	}

	@Override
	public Drug findDrugById(String drug_num) {
		Drug drug = mapper.findDrugById(drug_num);
		return drug;
	}

	@Override
	public void deleteDrugById(String drug_num) {
		mapper.deleteDrugById(drug_num);
	}

	@Override
	public void updateDrug(Drug drug) {
		mapper.updateDrug(drug);
	}
	
	
}
