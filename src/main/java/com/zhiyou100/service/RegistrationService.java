package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;

public interface RegistrationService {

	List<RegistrationInfor> findAllRegistration(Map<Object, Object> map);

	RegistrationInfor findRegistrationById(String medical_record);

	void updateRegistration(RegistrationInfor registrationInfor);

	void deleteRegistration(String medical_record, String status);

	void addRegistration(RegistrationInfor registrationInfor);

}
