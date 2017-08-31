<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息 - 智游客户关系管理系统</title>


<script type="text/javascript">

 function de(a){
	 var orConfirm =confirm("是否删除?");
	 if(orConfirm == false){
		 
		a.href="/Project/listUser";
	 }
	
}
 
</script> 

<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>用户信息</h3>
		<div class="actions">
		<form id="searchForm" action="<c:url value="/listUser" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name=keyword value="${keyword}" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="findname">
					<option value="u_name" ${findname eq "u_name" ? "selected":""}>用户名</option>
					<option value="u_phone" ${findname eq "u_phone" ? "selected":""}>手机号</option>
					<option value="u_address" ${findname eq "u_address" ? "selected":""}>地址</option>
					<option value="d_name" ${findname eq "d_name" ? "selected":""}>部门</option>
					<option value="r_name" ${findname eq "r_name" ? "selected":""}>角色</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				<a class="btn btn-primary" href="<c:url value="/addUser"/>">添加用户</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>部门</th>
                <th>角色</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
           	 <c:forEach var="user" items="${list }" varStatus="status">
            <tr>
                <td>${status.count+(pageInfo.currentPage-1)*10}</td>
              <td>
	                <a title="不要点" href="<c:url value="/lookUser?id="/>${user.u_id}" >${user.u_name }</a>
              </td>
                <td>${user.departmentName }</td>
                <td>${user.roleName }</td>
                <td>${user.u_phone }</td>
                <td>${user.u_mail }</td>
                <td>
                
               <fmt:formatDate value="${user.u_updatetime }" type="both" pattern="MM-dd HH:mm"/>
                
                </td>
                <td>
                	<a class="fa fa-pencil" title="修改"  href="<c:url value="/updateUser?id="/>${user.u_id}" ></a>
                	&nbsp;&nbsp;
  					<a class="fa fa-remove" title="删除"  onclick="de(this)" href="<c:url value="/deleteUser?id="/>${user.u_id}" ></a>
                </td>
            </tr>
            </c:forEach>
        </table>
         <%@ include file="/WEB-INF/page/page.jsp" %>
         
	</div>
</body>
</html>