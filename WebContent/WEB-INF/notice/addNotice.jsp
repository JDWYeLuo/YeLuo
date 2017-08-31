<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布公告 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>发布公告</h3>
		<form action="<c:url value="/addNotice"/>" method="post">
			<table class="form-table">
				 <tr>
					<td>发布时间</td>
					<td  class="control">
						<input type="datetime-local" name="n_begintime1" placeholder="选择发布时间">
					</td>
					<td>截止时间</td>
					<td class="control">
					<input type="datetime-local" name="n_endtime1"  placeholder="选择截止时间">
					</td>
				</tr> 

<tr bgcolor="white"><td align="center">主题</td>
	<td class="control"><input type="text" name="n_theme" class="p100" placeholder="请填写主题"></td>
	<td align="center">通知范围</td>
	
	<td class="control">
	<select name="n_departmentid" >
	<option value="0" ${notice.n_departmentid ==0?"selected":"" }>全部</option>
	<c:forEach items="${depart}" varStatus="status" var="depart">
	<option value="${depart.d_id}" >${depart.d_name}</option>
	</c:forEach>
	</select>
	</td>
	</tr> 


<tr height="200px" bgcolor="white" >
	<td >内容</td>
	<td colspan="3" class="control">
						<textarea class="p100" name="n_content" placeholder="请填写公告内容"></textarea>
					</td>
	</tr>

</table>
			<div class="buttons">
				<input type="hidden" name="n_userid" value="${user.u_id}">
			
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>