package com.zhiyou100.POI;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.util.ResponseObject;

/*
 * ajax实现上传服务器回显
 */
@Controller
public class ajaxUpload {
	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseObject ajaxUpload(MultipartFile img,HttpServletRequest request) throws IOException  {
		//1.获得上传的对象
		//2.获得最终上传的路径(上传服务器中的当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("获得最终上传的路径"+realPath);
		// 2.1将最终目的文件创建出来
		File file = new File(realPath);
		//判断该文件是否存在
		if(file.exists()) {
			//不存在则创创建出
		}
		//2.2 获得文件名
		/*
		 * 文件名重复时不能重复上传文件
		 */
		String fileName = img.getOriginalFilename();
		System.out.println("随机生成文件名"+fileName);
		/*
		 * 获得文件后缀名
		 */
		String[] split = fileName.split("\\.");
		System.out.println("获得后缀名"+Arrays.toString(split));
		String suffix = split[1];
		//以当前毫秒值为文件名
		long time = new Date().getTime();
		//最装文件名
		String newFileName = time+"."+suffix;
		System.out.println("新的文件名 : "+newFileName);
		System.out.println("文件名:"+fileName);
		//2.3确定上传路径
		File newFile = new File(file,newFileName);
		//3.上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		String path = "/upload/"+newFileName;
		return new ResponseObject("200","成功",path);
		
	}
}
