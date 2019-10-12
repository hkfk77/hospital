package com.zhiyou100.POI;


import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.csource.common.MyException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.util.FastDFSUtil;
import com.zhiyou100.util.ResponseObject;
@Controller
public class AjaxUploadFastDFS {
	@RequestMapping("/FastDFS.do")
	@ResponseBody
	public ResponseObject ajaxUploadFastDFS(MultipartFile img) throws IOException, MyException {
		ResponseObject obj = FastDFSUtil.upload(img);
	
		return 	obj;
	}
	@RequestMapping("/download.do")
	public void ajaxDownloadFastDFS(String fid,HttpServletResponse resp) throws IOException, Exception {
		System.out.println("Controller 接受id :"+fid);
		byte[] bytes= FastDFSUtil.download(fid);
		//浏览器下载弹框
		resp.setHeader("Content-disposition", "attachment;filename="+new Date().getTime()+".png");
		resp.setContentType("image/png");
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
}
