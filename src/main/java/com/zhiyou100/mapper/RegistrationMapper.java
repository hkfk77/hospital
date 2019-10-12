package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;

public interface RegistrationMapper {

	List<RegistrationInfor> findAllRegistration(Map<Object, Object> map);

	RegistrationInfor findRegistrationById(String medical_record);

	void updateRegistration(RegistrationInfor registrationInfor);

	void deleteRegistration(Map<String, String> map);

	void addRegistration(RegistrationInfor registrationInfor);

}
