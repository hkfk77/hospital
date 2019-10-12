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
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping("/list.do")
	public String findAllRegistration(
			String medical_record,
			String doctor_name,
			String section_name,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		
		Map<Object,Object> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("doctor_name", doctor_name);
		map.put("section_name", section_name);
		System.out.println(map);
//		map.put("time", time);
//		map.put("time1", time1);
		PageHelper.startPage(pageNo,2);
		List<RegistrationInfor> rInfors= service.findAllRegistration(map);
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(rInfors);
		request.setAttribute("rInfors", pageInfo.getList());
		System.out.println(pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "registration/index"; 
	}
	
	
	@RequestMapping("/detail.do")
	public String findRegistrationById(String medical_record,
			HttpServletRequest request 
			) {
		RegistrationInfor rInfor = service.findRegistrationById(medical_record);
		request.setAttribute("rInfor", rInfor); 
		return "registration/look";
		
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public String skipUpdatePage(
			String medical_record,
			HttpServletRequest request) {
		RegistrationInfor rInfor = service.findRegistrationById(medical_record);
		request.setAttribute("rInfor", rInfor); 
		return "registration/edit";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String updateRegistration(RegistrationInfor registrationInfor) {
		
		service.updateRegistration(registrationInfor);
		return "forward:/registration/list.do"; 
		
	}
	
	@RequestMapping("/delete.do")
	public String deleteRegistration(String medical_record,String status) {
		service.deleteRegistration(medical_record,status);
		return "forward:/registration/list.do";
		
	}
	
	@RequestMapping("/add.do")
	public String addRegistration() {
		return "registration/add";
		
	}
	
	@RequestMapping("/insert.do")
	public String addRegistration(RegistrationInfor registrationInfor) {
		
		service.addRegistration(registrationInfor);
		return "forward:/registration/list.do";
		
	}
	
}
