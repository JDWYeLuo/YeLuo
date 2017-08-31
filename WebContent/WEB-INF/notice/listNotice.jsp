<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告信息 - 智游客户关系管理系统</title>


<script type="text/javascript">

 function de(a){
	 var orConfirm =confirm("是否删除?");
	 if(orConfirm == false){
		 
		a.href="/Project/listNotice";
	 }
	
}
</script> 

<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>公告管理</h3>
		<div class="actions">
		<form id="searchForm" action="<c:url value="/listNotice" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name=noticeKeyword value="${noticeKeyword}" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="noticeFindname">
					<option value="n_theme" ${noticeFindname eq "n_theme" ? "selected":""}>主题</option>
					<option value="n_content" ${noticeFindname eq "n_content" ? "selected":""}>内容</option>
					
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				<a class="btn btn-primary" href="<c:url value="/addNotice?id="/>${notice.n_id}">发布公告</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>公告人</th>
                <th>公告主题</th>
                <th>通知范围</th>
                <th>公告内容</th>
                <th>公告时间</th>
                <th>截止时间</th>
                <th>操作</th>
            </tr>
           	 <c:forEach var="notice" items="${list }" varStatus="status">
            <tr>
                <td>${status.count+(pageInfo.currentPage-1)*10}</td>
                <td>${notice.u_name }</td>
                <td>${notice.n_theme }</td>
                <td>${notice.n_departmentid == 0?"全部":notice.d_name }</td>
                <td>
                	<a title="查看详情" href="<c:url value="/lookNotice?id=${notice.n_id}" />" >
                	<c:choose> 
				     	<c:when test="${fn:length(notice.n_content) > 25}"> 
				      		${ fn:substring(notice.n_content, 0, 25) }...
				     	</c:when> 
				     	<c:otherwise> 
				      		${notice.n_content}
				     	</c:otherwise>
				    </c:choose>
                	</a>
                </td>
                <td>
                	<fmt:formatDate value="${notice.n_begintime}" type="both" pattern="MM-dd HH:mm"/>
                </td>
                <td>
                	<fmt:formatDate value="${notice.n_endtime}" type="both" pattern="MM-dd HH:mm"/>
                </td>
                <td>
                	<a class="fa fa-pencil" title="更新" href="<c:url value="/updateNotice?id="/>${notice.n_id}"></a>
                	&nbsp;&nbsp;
                	<a class="fa fa-remove" title="删除"  onclick="de(this)" href="<c:url value="/deleteNotice?id="/>${notice.n_id}"></a>
                </td>
            </tr>
            </c:forEach>
        </table>
         <%@ include file="/WEB-INF/page/page.jsp" %>
         
	</div>
</body>
</html>