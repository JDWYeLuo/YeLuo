<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写邮件 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<script type="text/javascript">
function send(name){
	if(name=="send"){
		document.getElementsByName("m_sendstatus")[0].value = "1";
		document.getElementsByName("m_receivestatus")[0].value = "1";
	}else{
		document.getElementsByName("m_sendstatus")[0].value = "2";
		document.getElementsByName("m_receivestatus")[0].value = "0";
	}
	document.getElementsByTagName("form")[0].submit();
}
</script>
</head>
<body>
	<div class="box">
		<h3>写邮件</h3>
		<form action="<c:url value="/writeMail" />" method="post">
			<table class="form-table">
				<tr>
					<td>收件人</td>
					<td colspan="3" class="control">
						<select name="m_receiveid">
						<c:forEach var="u" items="${ users }">
							<c:if test="${u.u_id != user.u_id}">
							<option value="${ u.u_id }" ${u.u_id eq mail.m_receiveid?"selected":"" }>${ u.u_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>主题</td>
					<td colspan="3" class="control">
						<input type="text" name="m_theme" placeholder="请填写邮件主题" value=${mail.m_theme }>
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="m_content" placeholder="请填写邮件内容" >${mail.m_content }</textarea>
					</td>
				</tr>
			</table>
				<input type="hidden" name="m_id" value="${mail.m_id}">
				<input type="hidden" name="m_sendid" value="${user.u_id}">
				<input type="hidden" name="m_sendstatus" value="">
				<input type="hidden" name="m_receivestatus" value="">
			</form>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="button" name="send" value="发送" onclick="send(this.name)">&nbsp;&nbsp;
				<input class="btn btn-primary va-bottom" type="button" name="save" value="保存草稿" onclick="send(this.name)">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
	</div>
</body>
</html>