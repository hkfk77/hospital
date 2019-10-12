<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="#" id="formId">
	<input type="file" name="img"><br>
	<input type="button" value="上传" onclick="doUpload();">
	</form>
	<div>
		<img id="i1" alt="" width="500px" height="500px" src="">
	</div>
</body>
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript">
	function doUpload() {
		var formData = new FormData($("#formId")[0]);
		$.ajax({
			url:"/hospital/FastDFS.do",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data) {
			$("#i1").attr("src",data.obj.path);	
			}
		});
	}
</script>
</html>