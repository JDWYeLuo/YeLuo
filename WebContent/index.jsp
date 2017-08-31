<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
</head>
<body>
	<div class="login">
        <img src="${pageContext.request.contextPath }/image/logo.png" alt="智游">
        <p>智游客户关系管理系统</p>
        <form action="${pageContext.request.contextPath }/login" method="post">
            <div>
                <input type="text" id="username" name="username"  placeholder="请输入用户名">
            </div>
            <div>
                <input type="password" id="password" name="password" placeholder="请输入密码">
            </div>
            <%if("登录失败".equals(session.getAttribute("index"))){ %>
            <h3>用户账号或密码错误</h3>
            <% }%>
            <div>
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
</body>
</html>