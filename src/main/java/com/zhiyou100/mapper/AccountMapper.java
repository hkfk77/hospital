package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalClear;

public interface AccountMapper {

	List<HospitalClear> findAllAccount(Map<String, String> map);

	HospitalClear detailAccount(int id);

	void updateHospitalClear(Map<String, Object> map);

}
