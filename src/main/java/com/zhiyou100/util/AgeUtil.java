package com.zhiyou100.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhiyou100.model.Doctor;

public class AgeUtil {
	public static Doctor getAge(Doctor doctor) {
		
		String birther = doctor.getBirther();
		Date date = new Date();
		int age ;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String format = sd.format(date);
		String[] split = birther.split("-");
		String[] split2 = format.split("-");
		if(Integer.parseInt(split[1]) < Integer.parseInt(split2[1])) {
			age = Integer.parseInt(split2[0])-Integer.parseInt(split[0]);
			
		}else if(Integer.parseInt(split[1]) == Integer.parseInt(split2[1])) {
			if(Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
				age = Integer.parseInt(split2[0])-Integer.parseInt(split[0]);
			}else {
				age = Integer.parseInt(split2[0])-Integer.parseInt(split[0])-1;
			}
		}else {
			age = Integer.parseInt(split2[0])-Integer.parseInt(split[0])-1;
		}
		doctor.setAge(age);
		return doctor;
		
	}
}
