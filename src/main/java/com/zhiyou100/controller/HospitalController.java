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
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@RequestMapping("/list.do")
	public String findAllHospital(
			@RequestParam(defaultValue="1") int pageNo,
			String medical_record,
			String doctor_name,
			String section_name,
			String time,
			String time2,
			HttpServletRequest request) {

		String startTime = time;
		String endTime= time2;
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record); 
		map.put("doctor_name", doctor_name);
		map.put("section_name", section_name);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		PageHelper.startPage(pageNo,2);
		List<HospitalInfor>  hospitalInfor = service.findAllHospital(map);
		PageInfo<HospitalInfor> pageInfo = new PageInfo<>(hospitalInfor);
		request.setAttribute("hospitalInfor", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "hospital/index";
	}
	
	@RequestMapping("/detail.do")
	public String findHospitalById(String medical_record,HttpServletRequest request) {
		HospitalInfor hospitalInfor = service.findHospitalById(medical_record);
		request.setAttribute("h", hospitalInfor);
		return "hospital/look";
		
	}
	
	@RequestMapping("/add.do")
	public String addHospitalSkip() {
		return "hospital/add";
		
	}
	
	@RequestMapping("/insert.do")
	public String addHospital(HospitalInfor hospitalInfor) {
		service.insertHospital(hospitalInfor);
		return "forward:/hospital/list.do"; 
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public String updateHospitalSkip(String medical_record,HttpServletRequest request) {
		HospitalInfor hospitalInfor = service.findHospitalOneById(medical_record);
		request.setAttribute("h", hospitalInfor);
		return "hospital/edit";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String updateHospitalById(HospitalInfor hospitalInfor) {
		service.updateHospitalById(hospitalInfor);
		
		return "forward:/hospital/list.do";
	}
	
	@RequestMapping("discharge.do")
	public String deleteHospitalByid(String medical_record) {
		HospitalInfor hospitalInfor = service.findHospitalById(medical_record);
		String status = hospitalInfor.getRegistrationInfor().getStatus();
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("status", status);
		service.dischargeHospitalByid(map);
		return "forward:/hospital/list.do";
	}
	
	@RequestMapping("leave.do")
	public String leaveHospitalByid(String medical_record) {
		HospitalInfor hospitalInfor = service.findHospitalById(medical_record);
		String status = hospitalInfor.getRegistrationInfor().getStatus();
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("status", status);
		service.leaveHospitalByid(map);
		return "forward:/hospital/list.do";
	}
	
}
