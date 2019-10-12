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
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@RequestMapping("/list.do")
	public String findAllAccount(
			String medical_record,
			String name,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("name", name);
		PageHelper.startPage(pageNo, 2);
		List<HospitalClear> hospitalClear = service.findAllAccount(map);
		PageInfo<HospitalClear>  pageInfo = new PageInfo<>(hospitalClear);
		request.setAttribute("hospitalClear", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "hospital/account";
	}
	
	@RequestMapping("/detail.do")
	public String detailAccount(int id,
			@RequestParam(defaultValue="1") int pageNo,
			HttpServletRequest request) {
		HospitalClear hospitalClears = service.detailAccount(id);
		List<ChargeManager> chargeManager = hospitalClears.getChargeManager();
		double money = 0;
		for (ChargeManager chargeManager2 : chargeManager) {
			money = money + chargeManager2.getCharge_money();
		}
//		System.out.println(hospitalClears.getChargeManager());
//		PageHelper.startPage(pageNo, 3);
//		PageInfo<ChargeManager>  pageInfo = new PageInfo<>(hospitalClears.getChargeManager());
		request.setAttribute("hospitalClears", hospitalClears);
		request.setAttribute("money", money);
//		request.setAttribute("hospitalClear", pageInfo.getList());
//		System.out.println(pageInfo.getList()); 
//		request.setAttribute("page", pageInfo);
		return "hospital/account-look"; 
	}
	
	
	@RequestMapping("/edit.do")
	public String editAccount(int id,HttpServletRequest request) {
		HospitalClear hospitalClears = service.detailAccount(id);
		List<ChargeManager> chargeManager = hospitalClears.getChargeManager();
		double money = 0;
		for (ChargeManager chargeManager2 : chargeManager) {
			money = money + chargeManager2.getCharge_money();
		}
		money = hospitalClears.getBalance() - money ;
		Map<String,Object> map = new HashMap<>();
		map.put("money", money);
		map.put("id", id);
		service.updateHospitalClear(map); 
		return "forward:/account/list.do";
		
	}
	
	
}
