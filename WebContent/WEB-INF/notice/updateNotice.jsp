<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改公告 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>

	<div class="box">
		<h3>修改公告</h3>
		<form action="<c:url value="/updateNotice"/>" method="post" >
			<table class="form-table">
			 <tr>
					<td>发布时间</td>
					<td class="control">
						<input type="datetime" name="n_begintime" value="<fmt:formatDate value="${notice.n_begintime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" placeholder="选择发布时间">
					</td>
					<td>截止时间</td>
					<td class="control">
						<input type="datetime" name="n_endtime" value="<fmt:formatDate value="${notice.n_endtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" placeholder="选择截止时间">
					</td>
				</tr>

<tr bgcolor="white"><td align="center">主题</td>
	<td class="control"><input type="text" name="n_theme" placeholder="请填写主题" value=${notice.n_theme }></td>
	<td align="center">通知范围</td>
	<td class="control" >
			<select name="n_departmentid">
			<option value="0" ${notice.n_departmentid ==0?"selected":"" }>全部</option>
			<c:forEach items="${depart }" var="depart">
			<option value="${depart.d_id }" ${notice.n_departmentid ==depart.d_id?"selected":"" }>${depart.d_name }</option>
			</c:forEach>
			</select>
	</td>
</tr>
<tr height="200px" bgcolor="white" >
	<td >内容</td>
	<td colspan="3"><textarea rows="10" cols="100" name="n_content" placeholder="请填写公告内容" >${notice.n_content }</textarea></td>
</tr>

</table>
			<div class="buttons">
			<input type="hidden" name="n_id" value="${notice.n_id }">
			<input type="hidden" name="n_userid" value="${user.u_id }">
			<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>