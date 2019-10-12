package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalClear;


public interface AccountService {

	List<HospitalClear> findAllAccount(Map<String, String> map);

	HospitalClear detailAccount(int id);

	void updateHospitalClear(Map<String, Object> map);

}
