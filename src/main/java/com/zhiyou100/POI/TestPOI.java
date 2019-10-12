package com.zhiyou100.POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class TestPOI {
	/**
	 * 导出：从系统（程序）中导出到本地
	 * @throws Exception 
	 * 
	 */
	@Test
	public void pxport() throws Exception {
		//创建工作表
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建sheet
		HSSFSheet sheet1 = wb.createSheet("挂号信息");
		//3.在sheet中创建行:
		//参数:rownum指创建第几行 从0开始
		HSSFRow row0 = sheet1.createRow(0);
		//设置
		row0.setHeight((short) 500);
		//4.在行中创建列
		//参数:coumn 指创建第几列 从0开始
		HSSFCell r0c0 = row0.createCell(0);
		//5.单元格内写内容
		r0c0.setCellValue("门诊编号");
		//6.导出:输出流导出 文件后缀只能是xls
		OutputStream os=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.xls");
		//使用工作表导出
		wb.write(os);
		os.close();
		System.out.println("成功");
	}
	/**
	 * 导入:从本地导入项目
	 * @throws Exception 
	 */
	@Test
	public void importExcel() throws Exception {
		//1.将本地文件以输出流的形式读入程序
		InputStream in =new FileInputStream("C:\\Users\\Administrator\\Desktop\\1.xls");
		//2.通过流创建
		HSSFWorkbook wb = new HSSFWorkbook(in);
		//3.获得sheet ;根据sheet下标获得
		HSSFSheet sheet0 = wb.getSheetAt(0);
		//4.获得行;获得第二对象
		HSSFRow row1 = sheet0.getRow(1);
		//5.获得列:获得第二列
		HSSFCell r1c1 = row1.getCell(1);
		//6.获得值
		String value = r1c1.getStringCellValue();
		System.out.println("导入Excel,读取数据:"+value);
	} 
}
