package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.ChargeManager;

public interface ChargeMapper {

	List<ChargeManager> findAllCharge(Map<String, String> map);

	ChargeManager findCharge(String medical_record);

	void addCharge(ChargeManager chargeManager);

}
