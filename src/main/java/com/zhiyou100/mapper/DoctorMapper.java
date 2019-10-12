package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

public interface DoctorMapper {

	List<Doctor> findAllDoctor();

	Doctor detailDoctorById(int id);

	void editDoctorById(Doctor doctor);

	void insertDoctor(Doctor doctor);

	void delete(int i);

	List<Doctor> dimFindDoctor(Map<Object, Object> map);

}
