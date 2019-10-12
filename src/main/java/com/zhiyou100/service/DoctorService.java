package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

public interface DoctorService {

	List<Doctor> findAllDoctor();

	Doctor detailDoctorById(int id);

	void editDoctorById(Doctor doctor);

	void insertDoctor(Doctor doctor);

	void delete(int[] id);

	List<Doctor> dimFindDoctor(Map<Object, Object> map);

}
