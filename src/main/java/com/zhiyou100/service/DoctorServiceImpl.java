package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.util.AgeUtil;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorMapper mapper;
	
	@Override
	public List<Doctor> findAllDoctor() {
		List<Doctor> doctors = mapper.findAllDoctor();
		return doctors;
	}

	@Override
	public Doctor detailDoctorById(int id) {
		Doctor doctor = mapper.detailDoctorById(id);
		return doctor;
	}

	@Override
	public void editDoctorById(Doctor doctor1) {
		Doctor doctor = AgeUtil.getAge(doctor1);
		mapper.editDoctorById(doctor);
	}

	@Override
	public void insertDoctor(Doctor doctor1) {
		Doctor doctor = AgeUtil.getAge(doctor1);
		mapper.insertDoctor(doctor);
	}

	@Override
	public void delete(int[] id) {
		for (int i = 0; i < id.length; i++) {
			mapper.delete(id[i]);
		}
	}

	@Override
	public List<Doctor> dimFindDoctor(Map<Object, Object> map) {
		List<Doctor> doctors = mapper.dimFindDoctor(map);
		return doctors;
	}

}
