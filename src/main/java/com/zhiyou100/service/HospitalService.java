package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;

public interface HospitalService {

	List<HospitalInfor> findAllHospital(Map<String, String> map);

	HospitalInfor findHospitalById(String medical_record);

	void insertHospital(HospitalInfor hospitalInfor);

	void updateHospitalById(HospitalInfor hospitalInfor);

	HospitalInfor findHospitalOneById(String medical_record);

	void dischargeHospitalByid(Map<String, String> map);

	void leaveHospitalByid(Map<String, String> map);

}
