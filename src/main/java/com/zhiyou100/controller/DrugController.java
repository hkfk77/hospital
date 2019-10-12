package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Drug;

import com.zhiyou100.service.DrugService;

@Controller
@RequestMapping("/drug")
public class DrugController {

	@Autowired
	private DrugService service;
	
	@RequestMapping("/list.do")
	public String findAllDrug(
			@RequestParam(defaultValue="1") int pageNo,
			String drug_name, 
			String drug_type,
			HttpServletRequest request) {
		Map<String,String> map = new HashMap<>();
		map.put("drug_name", drug_name);
		map.put("drug_type", drug_type);
		System.out.println("map"+map);
		PageHelper.startPage(pageNo,2);
		List<Drug> drugs = service.findAllDrug(map);
		PageInfo<Drug> pageInfo = new PageInfo<>(drugs);
		request.setAttribute("drugs", pageInfo.getList());
		System.out.println("111"+pageInfo.getList());
		request.setAttribute("map", map);
		request.setAttribute("page", pageInfo);
		return "medicine/index";
	}
	
	@RequestMapping("/add.do")
	public String addDrugSkip() {
		return "medicine/add";
	}
	
	@RequestMapping("/insert.do")
	public String addDrug(@RequestParam("img")MultipartFile img,
			Drug drug,
			HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		// 2.1 将最终目的地创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if(file.exists()) {
			//不存在则创建
			file.mkdir();
		}
		String fileName = img.getOriginalFilename();
		File newFile = new File(file,fileName);
		try {
			FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileName);
		drug.setDrug_url(fileName); 
		service.addDrug(drug);
		
		return "forward:/drug/list.do"; 
	}
	
	@RequestMapping("/detail.do")
	public String findDrugById(String drug_num,HttpServletRequest request) {
		Drug drug = service.findDrugById(drug_num);
		request.setAttribute("d", drug);
		return "medicine/look"; 
	}
	
	@RequestMapping("/delete.do")
	public String deleteDrugById(String drug_num) {
		service.deleteDrugById(drug_num);
		return "forward:/drug/list.do";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public String updateDrug(String drug_num,HttpServletRequest request) {
		Drug drug = service.findDrugById(drug_num);
		request.setAttribute("d", drug);
		return "medicine/edit";
		
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public String updateDrug(Drug drug) {
		System.out.println(drug);
		service.updateDrug(drug);
		return "forward:/drug/list.do";
		 
	}
	
}
