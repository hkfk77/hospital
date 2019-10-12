package com.zhiyou100.POI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class TestFastDFS {

	public static void main(String[] args) throws IOException, MyException {
		// 1. 加载配置文件
	ClientGlobal.init("C://Users//Administrator//Desktop//sss//hospital//src//main//resourcesfastdfs-client.properties");
		// 2. 创建管理端对象
		TrackerClient trackerClient = new TrackerClient();
		// 3. 通过管理端对象获取连接
		TrackerServer connection = trackerClient.getConnection();
		// 4. 创建存储端对象
		StorageClient1 storageClient = new StorageClient1(connection, null);

		// 创建文件属性信息对象数组
//		NameValuePair meta_list [] = new NameValuePair[]{ 
//    
//				new NameValuePair("item_id", "100010"), 
//                new NameValuePair("width", "80"),
//                new NameValuePair("height", "90")
//        };

		NameValuePair[] meta_list = new NameValuePair[1];
		meta_list[0] = new NameValuePair("fileName", "2.jpg");

		// 5. 上传文件
		
		//  参数1:要上传的文件地址
		// 参数2:要上传的文件类型
		//  参数3:文件属性信息对象数组
		//  返回值 : 存储在Storage中的地址
		 
		String path = storageClient.upload_file1("C://Users//Administrator//Desktop//2.jpg", "jpg", meta_list);
		System.out.println("path : "+ path);
		System.out.println("结束");
	
	
	/*
		String fid ="group1/M00/00/00/wKi8gF2IclOATUsdAACvkYy_FjE753.jpg";
		ClientGlobal.init("C://Users//Administrator//Desktop//新建文件夹//hospital//src//main//resources//fastdfs-client.properties");
		// 2. 创建管理端对象
		TrackerClient trackerClient = new TrackerClient();
		// 3. 通过管理端对象获取连接
		TrackerServer connection = trackerClient.getConnection();
		// 4. 创建存储端对象
		StorageClient1 storageClient = new StorageClient1(connection, null);
		byte[] download_file1 = storageClient.download_file1(fid);
		OutputStream out= new FileOutputStream("C://Users//Administrator//Desktop//3.jpg");
		out.write(download_file1);
		out.close();
		System.out.println("下载成功");*/
		
		
		
		
		
		
	/*	String fid ="group1/M00/00/00/wKi8gF2IclOATUsdAACvkYy_FjE753.jpg";
		ClientGlobal.init("C:\\Users\\Administrator\\Desktop\\sss\\hospital\\src\\main\\resources\\fastdfs-client.properties");
		// 2. 创建管理端对象
		TrackerClient trackerClient = new TrackerClient();
		// 3. 通过管理端对象获取连接
		TrackerServer connection = trackerClient.getConnection();
		// 4. 创建存储端对象
		StorageClient1 storageClient = new StorageClient1(connection, null);
		int i=storageClient.delete_file1(fid);
		System.out.println(i);
		System.out.println("删除成功");*/
	}

}


