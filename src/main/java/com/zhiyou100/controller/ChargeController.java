package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.service.ChargeService;

@Controller
@RequestMapping("/charge")
public class ChargeController {

	@Autowired
	private ChargeService service;
	
	@RequestMapping("/list.do")
	public String findAllCharge(
			String medical_record,
			String name,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("name", name);
		PageHelper.startPage(pageNo,2);
		List<ChargeManager> chargeManager = service.findAllCharge(map);
		PageInfo<ChargeManager> pageInfo = new PageInfo<>(chargeManager);
		request.setAttribute("chargeManager", pageInfo.getList()); 
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "hospital/charge";
	}
	
	
	
	@RequestMapping("/add.do")
	public String addSkip(String medical_record,HttpServletRequest request) {
		ChargeManager chargeManager = service.findCharge(medical_record);
		request.setAttribute("c", chargeManager);
		return "hospital/charge-new";
		
	}
	
	@RequestMapping("/add2.do")
	public String addCharge(ChargeManager chargeManager) {
		service.addCharge(chargeManager);
		return "forward:/charge/list.do";
	}
}
