<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/lookUser"/>" method="post">
     <table width="900px" height="600px" align="center" cellspacing="1px" bgcolor="black">
       <caption>用户信息</caption>
        <tr bgcolor="white">
           <td>用户名</td>
           <td>${user.u_name }</td>
           <td>密码</td>
           <td>${user.u_pwd}</td>
        </tr>
        <tr bgcolor="white">
           <td>部门</td>
           <td>${user.departmentName }</td>
           <td>角色</td>
           <td>${user.roleName }</td>
        </tr>
        <tr bgcolor="white">
           <td>性别</td>
           <td>${user.u_sex }</td>
           <td>手机号</td>
           <td>${user.u_phone }</td>
        </tr>
        <tr bgcolor="white">
           <td>地址</td>
           <td>${user.u_address }</td>
           <td>年龄</td>
           <td>${user.u_age }</td>
        </tr>
        <tr bgcolor="white">
           <td>固定电话</td>
           <td>${user.u_telphone }</td>
           <td>身份证号</td>
           <td>${user.u_idcard }</td>
        </tr>
        <tr bgcolor="white">
           <td>电子邮箱</td>
           <td>${user.u_mail}</td>
           <td>qq号</td>
           <td>${user.u_qq }</td>
        </tr>
        <tr bgcolor="white">
           <td>爱好</td>
           <td>${user.u_hobby }</td>
           <td>学历</td>
           <td>${user. getU_edu() }</td>
        </tr>
        <tr bgcolor="white">
           <td>工资卡号</td>
           <td>${user.getU_salarycard() }</td>
           <td>民族</td>
           <td>${user.getU_nation() }</td>
        </tr>
        <tr bgcolor="white">
           <td>婚姻状况</td>
           <td>${user.getU_marry() }</td>
           <td></td>
           <td></td>
        </tr>
        <tr bgcolor="white">
           <td>备注</td>
           <td colspan="3">${user.getU_remark() }</td>
        </tr>
    </table> 
    </form>
    <a href="javascript:history.go(-1)">返回</a>
</body>
</html>
