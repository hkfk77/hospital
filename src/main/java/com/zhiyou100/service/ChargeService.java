package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.ChargeManager;


public interface ChargeService {

	List<ChargeManager> findAllCharge(Map<String, String> map);

	ChargeManager findCharge(String medical_record);

	void addCharge(ChargeManager chargeManager);

}
