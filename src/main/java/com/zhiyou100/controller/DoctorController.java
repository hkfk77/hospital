package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
//	@RequestMapping("/list.do")
//	public String findAllDoctor(
//			
//			HttpServletRequest request) {
//		
//		List<Doctor> doctors = service.findAllDoctor();
////		System.out.println(doctors);
//		request.setAttribute("doctors", doctors);
//		return "/doctor/doctorIndex";
//	}
	
	@RequestMapping("/list.do")
	public String findAllDoctor(
			@RequestParam(defaultValue="1") int pageNo,
			String id,
			String name,
			String section,
			HttpServletRequest request
			) {
		Map<Object,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("section", section);
		PageHelper.startPage(pageNo,2);
		List<Doctor> doctors = service.dimFindDoctor(map);
		PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
//		System.out.println(doctors);
		request.setAttribute("doctors", pageInfo.getList()); 
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "/doctor/doctorIndex";
	}
	
	@RequestMapping("/detail.do")
	public String detailDoctorById(int id,HttpServletRequest request) {
		Doctor doctor = service.detailDoctorById(id);
		request.setAttribute("doctor", doctor);
		return "doctor/doctorLook";
		
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public String editDoctorById(int id,HttpServletRequest request) {
		Doctor doctor = service.detailDoctorById(id);
		request.setAttribute("doctor", doctor);
		return "doctor/doctorEdit"; 
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String editDoctorById(Doctor doctor,HttpServletRequest request) {
		service.editDoctorById(doctor);
		return "forward:/doctor/list.do";
	}
	
	@RequestMapping("/add.do")
	public String add() {
		return "doctor/doctorAdd"; 
	}
	
	@RequestMapping("/insert.do")
	public String insert(Doctor doctor) {
		
		service.insertDoctor(doctor); 
		return "forward:/doctor/list.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int[] id) {
		service.delete(id);
		return "forward:/doctor/list.do"; 
		
	}
	
}
