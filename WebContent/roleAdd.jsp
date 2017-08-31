<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath }/role">
	<table  width="1200px" height="340px" cellspacing="1px" bgcolor="black">
	<caption><h2></h2></caption>
	<tr height="40px" bgcolor="white">
	<td align="center" width="200px">角色名称</td>
	<td><input type="text" name="r_name" placeholder="填写角色名称"></td>
</tr>
	<tr height="300px" bgcolor="white" >
	<td align="center" width="200px">角色描述</td>
	<td colspan="3"><textarea rows="10" cols="100" name="r_desc"></textarea></td>
</tr>
	</table>
	<div>
	<input type="submit" value="保存">
	<a href="javascript:history.go(-1)"><input type="button" value="返回" ></a>
	</div>
	</form>
	
</body>
</html>