<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" id="formid">
	<input type="file" name="img"><br>
	<input type="button" value="上传" onclick="doUpload();">
	<input type="button" value="下载" onclick="download();">
	<input type="hidden" value="" id="hid">
	</form>
	<div>
	<img  id="i1" alt="" width="500px" height="500px" src="">
	</div>
</body>
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript">
	function doUpload(){
		var formData = new FormData($("#formid")[0]);
		$.ajax({
			url:"/hospital/FastDFS.do",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data){
				alert(data.obj);
				$("#i1").attr("src",data.obj.path);
				//fid 赋值给隐藏的输入框
				$("#hid").val(data.obj.fid);
			}
		});
		 
	}
	function download(){
		alert("准备下载")
		//获得id
		var fid =$("#hid").val();
		window.open("http://localhost:8080/hospital/download.do?fid="+fid); 
	}
</script>
</html>