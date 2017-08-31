<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">

<!-- private int m_sendstatus;//1表示发送2表示草稿,3表示垃圾箱4表示删除
	private int m_receivestatus;//1表示接收2表示垃圾箱4表示删除 -->
	
<script type="text/javascript">
function save(name){
	if(name == "send"){
		document.getElementsByName("m_sendstatus")[0].value="1";
		document.getElementsByName("m_receivestatus")[0].value="1";
	}else{
		document.getElementsByName("m_sendstatus")[0].value="2";
		document.getElementsByName("m_receivestatus")[0].value="0";
	}
	document.getElementsByTagName("form")[0].submit();
}
</script>

</head>
<body>
 <div class="box">
	<form action="<c:url value="/writeMail"/>" method="post">
	<table class="form-table">
	<tr bgcolor="white">
	
	<td>收件人</td>
		<td colspan="3" class="control">
        <select name="m_receiveid" >
        <c:forEach items="${theUser }" varStatus="stu" var="stm">
        <c:if test="${stm.u_id!=user.u_id}">
		<option value="${stm.u_id }" >${stm.u_name }</option>
		</c:if>
		</c:forEach>
		</select>
        </td>
	</tr> 
	
	<tr bgcolor="white">
	<td align="center">主题</td>
	<td colspan="3" class="control">
	<input type="text" name="m_theme" class="p100" placeholder="请填写邮件主题"></td>
	</tr> 
			
	<tr height="200px" bgcolor="white" >
	<td >内容</td>
	<td colspan="3" class="control">
	<textarea class="p100" name="m_content" placeholder="请填写邮件内容"></textarea>
	</td>
	</tr>
	
	</table>
	<!--1.发件人id 2.m_sendstatus 3.m_receivestatus -->
	<input type="hidden" name="m_sendid" value="${user.u_id }">
	<input type="hidden" name="m_sendstatus" value="">
	<input type="hidden" name="m_receivestatus" value="">
	</form>
	<div class="buttons">
			<input class="btn btn-primary va-bottom" type="button" name="send" value="发送" onclick="save(this.name)">&nbsp;&nbsp;
			<input class="btn btn-primary va-bottom" type="button" name="save" value="保存草稿" onclick="save(this.name)">&nbsp;&nbsp;
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>

</div>

</body>
</html>