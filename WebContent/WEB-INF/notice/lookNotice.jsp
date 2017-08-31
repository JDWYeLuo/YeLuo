<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/lookNotice"/>" method="post">
      <table width="900px" height="600px" align="center" cellspacing="1px" bgcolor="black">
       <caption>公告信息</caption>
			 <tr bgcolor="white">
					<td>发布时间</td>
					<td class="control">
			<fmt:formatDate value="${notice.n_begintime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>截止时间</td>
					<td class="control">
			<fmt:formatDate value="${notice.n_endtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
	<tr bgcolor="white"><td align="center">主题</td>
	<td class="control">${notice.n_theme }</td>
	<td align="center">通知范围</td>
	<td class="control" value="0" ${notice.n_departmentid ==0?"selected":"" }>${notice.d_name }</td>
	</tr>
<tr height="200px" bgcolor="white" >
	<td >内容</td>
	<td colspan="3">${notice.n_content }</td>
</tr>
				
	
    </table> 
    </form>
    <a href="javascript:history.go(-1)">返回</a>
</body>
</html>