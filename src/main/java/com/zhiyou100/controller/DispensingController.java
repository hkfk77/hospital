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
import com.zhiyou100.model.Dispensing;
import com.zhiyou100.service.DispensingService;

@Controller
@RequestMapping("/dispensing")
public class DispensingController {

	@Autowired
	private DispensingService service;

	@RequestMapping("/list.do")
	public String findAllDispensing(String medical_record, 
			@RequestParam(defaultValue = "1") int pageNo,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		map.put("medical_record", medical_record);
		PageHelper.startPage(pageNo, 2);
		List<Dispensing> dispensing = service.findAllDispensing(map);
		PageInfo<Dispensing> pageInfo = new PageInfo<>(dispensing);
//		System.out.println(pageInfo.getList());
		request.setAttribute("dispensing", pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "hospital/dispensing";
	}
	
	
	@RequestMapping("/dispensing_give.do")
	public String dispensingGiveSkip(String medical_record,HttpServletRequest request) {
		Dispensing dispensing =  service.dispensingGive(medical_record);
		request.setAttribute("d", dispensing);
		return "hospital/dispensing-give";
	}
	
	@RequestMapping("/give.do")
	public String dispensingGive(String medical_record,int dispens_num) {
		System.out.println("medical_record  " + medical_record);
		Dispensing dispensing1 =  service.dispensingGive(medical_record);
		System.out.println(dispensing1);
		Integer num = dispensing1.getDispens_num(); 
		Integer alread_send_num = dispensing1.getAlread_send_num();
		dispens_num = num + dispens_num;
		int not_send_num = dispens_num-alread_send_num;
		Map<String,Object> map = new HashMap<>();
		map.put("medical_record", medical_record);
		map.put("dispens_num", dispens_num);
		map.put("not_send_num", not_send_num);
		service.updateDispensing(map);
		return "forward:/dispensing/list.do";
	}
	
	@RequestMapping("/dispensing_look.do")
	public String detailDispensing(String medical_record,HttpServletRequest request) {
		Dispensing dispensing = service.dispensingDetail(medical_record);
		request.setAttribute("d", dispensing);
		return "hospital/dispensing-look";
	}
	
	@RequestMapping("/deliverAll")
	public String deliverAll(String medical_record) {
		Dispensing dispensing = service.dispensingDetail(medical_record);
		service.updateNum(dispensing);
		return "forward:/dispensing/dispensing_look.do";
		
	}
	
	@RequestMapping("/deliverOne")
	public String deliverOne(String medical_record) {
		Dispensing dispensing = service.dispensingDetail(medical_record);
		service.updateOne(dispensing);
		return "forward:/dispensing/dispensing_look.do";
		
	}
	
	@RequestMapping("/deliverFive")
	public String deliverFive(String medical_record) {
		Dispensing dispensing = service.dispensingDetail(medical_record);
		service.updateFive(dispensing);
		return "forward:/dispensing/dispensing_look.do"; 
		
	}
	
	@RequestMapping("/deliver")
	public String deliver(String medical_record) {
		Dispensing dispensing = service.dispensingDetail(medical_record);
		service.updateDelive(dispensing);
		return "forward:/dispensing/dispensing_look.do";
		
	}
	
}
