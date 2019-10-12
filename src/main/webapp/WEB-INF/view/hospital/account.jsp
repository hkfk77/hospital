<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>住院结算-- -2015</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	$(function() {
		$('#newNav')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/dispensing/dispensing-gives.do ";
						});
	});

	function checkall() {
		var alls = document.getElementsByName("check");
		var ch = document.getElementById("checkall");
		if (ch.checked) {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = true;
			}
		} else {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = false;
			}
		}
	}
	function delAll() {
		var alls = document.getElementsByName("check");
		var ids = new Array();
		for (var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				ids.push(alls[i].value);
			}
		}
		if (ids.length > 0) {
			if (confirm("确认操作?")) {
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
</script>
</head>
<body>

	<form action="${pageContext.request.contextPath}/account/list.do"
		method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">病例号：</td>
				<td><input type="text" name="medical_record" value="" /></td>
				<td width="10%" class="tableleft">姓名：</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td colspan="4"><center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="submit" class="btn btn-primary" type="button">清空</button>
					</center></td>
			</tr>
		</table>
	</form>

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
				<th>病历号</th>
				<th>姓名</th>
				<th>押金</th>
				<th>当前余额</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${hospitalClear}" var="h">
			<tr>
				<td style="vertical-align: middle;"><input type="checkbox"
					name="check" value="${h.id }"></td>
				<td style="vertical-align: middle;">${h.medical_record }</td>
				<td style="vertical-align: middle;">${h.registrationInfor.name }</td>
				<td style="vertical-align: middle;">${h.hospitalInfor.pay_the_deposit }元</td>
				<td style="vertical-align: middle;">${h.balance }元</td>
				<td style="vertical-align: middle;">${h.clear_status }</td>
				<td style="vertical-align: middle;">
					<a href="${pageContext.request.contextPath}/account/detail.do?id=${h.id}">详细信息</a>
					&nbsp;&nbsp;&nbsp; 
					<a href="${pageContext.request.contextPath}/account/edit.do?id=${h.id}">结算</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<th colspan="5">
				<div class="inline pull-right page">
					<a
						href='<c:url value='/account/list.do?pageNo=${1 }&medical_record=${map.medical_record }&name=${map.name }' />'>第一页</a>
					<c:choose>
						<c:when test="${page.pageNum == 1 }">
							<a href="#"> </a>
						</c:when>
						<c:otherwise>
							<a
								href='<c:url value='/account/list.do?pageNo=${page.pageNum-1 }&medical_record=${map.medical_record }&name=${map.name }' />'>上一页</a>
						</c:otherwise>
					</c:choose>
					<c:forEach var="i" begin="1" end="${page.pages }" step="1">
						<a
							href="<c:url value='/account/list.do?pageNo=${i }&medical_record=${map.medical_record }&name=${map.name }' />">${i }</a>
					</c:forEach>
					<c:choose>
						<c:when test="${page.pageNum == page.pageSize }">
							<a href="#"> </a>
						</c:when>
						<c:otherwise>
							<a
								href='<c:url value='/account/list.do?pageNo=${page.pageNum+1 }&medical_record=${map.medical_record }&name=${map.name }' />'>下一页</a>
						</c:otherwise>
					</c:choose>
					<a
						href='<c:url value='/account/list.do?pageNo=${page.pages }&medical_record=${map.medical_record }&name=${map.name }' />'>最后一页</a>
					&nbsp;&nbsp;&nbsp; 共<span class='current'>${page.total }</span>条记录,第
					<span class='current'> ${page.pageNum }/${page.pages } </span>页
				</div>
				<div>
					<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
				</div>
			</th>
		</tr>
	</table>


</body>
</html>
