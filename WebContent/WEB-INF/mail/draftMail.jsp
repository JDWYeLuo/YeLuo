<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收件箱 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>草稿箱</h3>
		<div class="actions">
			<form id="searchForm" action="<c:url value="draftMail" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name="draftMailKeyWord" value="${ draftMailKeyWord }" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="draftMailSearchField">
					<option value="m_theme" ${ draftMailSearchField=="m_theme"?"selected":"" }>主题</option>
					<option value="m_content" ${ draftMailSearchField=="m_content"?"selected":"" }>内容</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				<a class="btn btn-primary" href="<c:url value="/writeMail" />">写邮件</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>发件人</th>
                <th>收件人</th>
                <th>主题</th>
                <th>发送时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="mail" items="${ list }" varStatus="status">
            <tr>
                <td>${ status.count+(pageInfo.currentPage-1)*10 }</td>
                <td>${ mail.sendName }</td>
                <td>${ mail.receiveName }</td>
                <td>
	              <a title="查看详情" href="<c:url value="/updateMail?id=" />${mail.m_id}" >
	                ${ mail.m_theme }
	                </a>
                </td>
                <td>
                	<fmt:formatDate value="${mail.m_sendtime}" type="both" pattern="yyyy-MM-dd HH:mm"/>
                </td>
                <td>
                	<a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${mail.m_id})"></a>
                </td>
            </tr>
            </c:forEach>
            <c:if test="${empty list}">
    		<tr>
    			<td colspan="5">
    				没有邮件..
    			</td>
    		</tr>
    		</c:if>
        </table>
    	  <%@ include file="/WEB-INF/page/page.jsp" %>
	</div> 
	<script>
    	function confirmDelete(id){
    		if (confirm("是否删除？")) {
    			location.href = '<c:url value="/deleteMail?status=m_sendstatus=3&id=" />' + id
    		}
    	}
    </script>
</body>
</html>