<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/permission/update.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
    	<tr>
            <td width="10%" class="tableleft">权限id</td>
            <td><input type="text" name="id" readonly="readonly" value="${p.id }"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">资源名称</td>
            <td><input type="text" name="resource_name" value="${p.resource_name }"/></td>
        </tr>
        <tr>
            <td class="tableleft">url</td>
            <td><input type="text" name="resource_url" value="${p.resource_url }"/></td>
        </tr>
        <tr>
            <td class="tableleft">是否有效</td>
            <td>
            	<c:choose>
            		<c:when test="${p.status == 1 }">
            			<input type="radio" name="status" value="1" checked/> 有效
              			<input type="radio" name="status" value="2" /> 无效
            		</c:when>
            		<c:when test="${p.status == 2 }">
            			<input type="radio" name="status" value="1" /> 有效
              			<input type="radio" name="status" value="2" checked/> 无效
            		</c:when>
            	</c:choose>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>
                &nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
                                                                                            
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/permission/list.do ";
		 });
    });
</script>