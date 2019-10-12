package com.zhiyou100.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;

import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class FastDFSUtil {
	public static ResponseObject upload(MultipartFile img) throws IOException, MyException {
		// 获得文件名
		String fileName = img.getOriginalFilename();
		// 获得后缀
		String[] split = fileName.split("\\.");
		String suffix = split[1];
		
//		加载配置文件
		// 绝对路径
		ClientGlobal.init("C:\\Users\\Administrator\\Desktop\\sss\\hospital\\src\\main\\resources\\fastdfs-client.properties");
//		创建Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
//		通过Tracker客户端得到Tracker对象
		TrackerServer connection = trackerClient.getConnection();
//		通过Tracker得到Storage客户端
		StorageClient1 storageClient1 = new StorageClient1(connection,null);
//		创建文件属性存储对象
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName",fileName);
//		通过客户端执行上传
		// 参1 文件的地址 : 绝对路径 参2 文件类型  参3 文件属性对象数组
		
		String fid = storageClient1.upload_file1(img.getBytes(),suffix,list);
		System.out.println("上传成功 : "+fid);
		String path = "http://java21:81/"+fid;
		Map<String,String> map =new HashMap<>();
		map.put("th", path);
		map.put(fid, fid);
		return new ResponseObject("200","成功",map);
		
	}
	
	public static byte[] download(String fid) throws IOException, Exception {
		System.out.println("接受下载图片地址"+fid);
		
		
		//String[] split = img.split("/");
		ClientGlobal.init("C:\\Users\\Administrator\\Desktop\\sss\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 2. 创建管理端对象
		TrackerClient trackerClient = new TrackerClient();
		// 3. 通过管理端对象获取连接
		TrackerServer connection = trackerClient.getConnection();
		// 4. 创建存储端对象
		StorageClient1 storageClient = new StorageClient1(connection, null);
		byte[] bytes = storageClient.download_file1(fid);
		return bytes;
		
		
		
	
	
		
	}
}
