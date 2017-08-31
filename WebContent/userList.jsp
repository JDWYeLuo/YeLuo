<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页 - 智游客户关系管理系统</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/userWork.jsp">
	搜索内容:<input type="text" name="keyword" placeholder="请输入搜索关键字">
	搜索字段:<select name="username" >
		<option value="用户名">用户名</option>
		<option value="部门">部门</option>
		<option value="角色">角色</option>
		<option value="手机号">手机号</option>
		<option value="邮箱">邮箱</option>
		<option value="更新时间">更新时间</option>
		</select>
		<input type="submit" value="搜索" >
<a href="javascript:history.go(-1)"><input type="submit" value="添加用户" ></a>

<table  width="1000px" height="250px" cellspacing="1px" bgcolor="black">
<tr bgcolor="white">
	<td align="center">序号</td>
	<td align="center">用户名</td>
	<td align="center">部门</td>
	<td align="center">角色</td>
	<td align="center">手机号</td>
	<td align="center">邮箱</td>
	<td align="center">更新时间</td>
</tr>
<tr bgcolor="white">
	<td >${BeanWork.u.id}</td>
	<td >${BeanWork.u.name}</td>
	<td >${BeanWork.u.department}</td>
	<td >${BeanWork.u.roleid}</td>
	<td >${BeanWork.u.phone}</td>
	<td >${BeanWork.u.mail}</td>
	<td >${BeanWork.u.updatetime}</td>
</tr>

</table>
</form>

</body>
</html>