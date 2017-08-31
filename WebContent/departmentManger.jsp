<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息 - 智游客户关系管理系统</title>
<h1>部门</h1>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<style >
.TongYong{
float: right;
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath }/list">
<a href="${pageContext.request.contextPath }/addSection.jsp"><input type="button" value="添加部门" class="TongYong"></a>
<table  width="1200px"  cellspacing="1px" bgcolor="black">
<tr bgcolor="white" height="40px">
	<td align="center">序号</td>
	<td align="center">部门名称</td>
	<td align="center">部门描述</td>
	<td align="center">更新时间</td>
	<td align="center">操作</td>
</tr>

<c:forEach items="${ser}" varStatus="status" var="item">
<tr bgcolor="white" height="40px">
	<td >${status.index+1}</td>
	<td >${item.getD_name()}</td>
	<td >${item.getD_desc()}</td>
	<td >更新时间</td>
	<td ><a class="fa fa-pencil" title="编辑"></a>
	<a class="fa fa-remove" title="编辑"></a></td>
</tr> 

</c:forEach>
</table>

</form>
</body>
</html>