<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
共有 ${pageInfo.totalDataCount } 条记录，第 ${pageInfo.currentPage}/${pageInfo.totalPage} 页

<div style="float: right; margin-right: 10px;">
<c:choose>
<c:when test="${pageInfo.currentPage != 1 }">

<a href="${pageInfo.servletPath}${pageInfo.currentPage -1 }">上一页</a>

</c:when>

<c:otherwise>

<a>上一页</a>
</c:otherwise>
</c:choose>
<c:forEach begin="${pageInfo.beginPage}" end="${pageInfo.endPage }" varStatus="status">
<c:choose>
	<c:when test="${status.index == pageInfo.currentPage }">
	<a style="color: red;">${status.index}</a>
	</c:when>
	<c:otherwise>
	<a href="${pageInfo.servletPath}${status.index }">${status.index}</a>
	</c:otherwise>
</c:choose>
</c:forEach>

<c:choose>
<c:when test="${pageInfo.currentPage != pageInfo.totalPage }">

<a href="${pageInfo.servletPath}${pageInfo.currentPage +1 }">下一页</a>

</c:when>

<c:otherwise>

<a>下一页</a>

</c:otherwise>
  
</c:choose>
</div>
</div>
</body>
</html>