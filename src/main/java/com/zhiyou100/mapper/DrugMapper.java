package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Drug;

public interface DrugMapper {

	List<Drug> findAllDrug(Map<String, String> map);

	void addDrug(Drug drug);

	Drug findDrugById(String drug_num);

	void deleteDrugById(String drug_num);

	void updateDrug(Drug drug);

}
