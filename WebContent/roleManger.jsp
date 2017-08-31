<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理 - 智游客户关系管理系统</title>
<h1>角色管理</h1>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<style >
.TongYong{
float: right;
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath }/role">
<a href="${pageContext.request.contextPath }/roleAdd.jsp"><input type="button" value="添加角色" class="TongYong"></a>
<table  width="1200px"  cellspacing="1px" bgcolor="black">
<tr bgcolor="white" height="40px">
	<td align="center">序号</td>
	<td align="center">角色名称</td>
	<td align="center">角色描述</td>
	<td align="center">更新时间</td>
	<td align="center">操作</td>
</tr>

<c:forEach items="${min}" varStatus="status" var="iteml">
<tr bgcolor="white" height="40px">
	<td >${status.count}</td>
	<td >${iteml.getR_name()}</td>
	<td >${iteml.getR_desc()}</td>
	<td >更新时间</td>
	<td ><a class="fa fa-pencil" title="编辑"></a>
	<a class="fa fa-remove" title="编辑"></a></td>
</tr> 

</c:forEach>
</table>

</form>
</body>
</html>