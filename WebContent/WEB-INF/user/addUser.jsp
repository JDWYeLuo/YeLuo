<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>添加用户</h3>
		<form action="<c:url value="/addUser"/>" method="post">
			<table class="form-table">
				<tr>
					<td>用户名</td>
					<td  class="control">
						<input type="text" name="u_name" placeholder="填写用户名称">
					</td>
					<td>密码</td>
					<td class="control">
					<input type="password" name="u_pwd" placeholder="请填写密码"></td>
				</tr>
<tr bgcolor="white">
	<td>部门</td>
	<td class="control">
	<select name="u_departmentid" >
	<c:forEach items="${depart}" varStatus="status" var="user">
	<option value="${user.getD_id()}" >${user.getD_name()}</option>
	</c:forEach>
	</select>
	</td>
	<td>角色</td>
	<td class="control">
	<select name="u_roleid" >
	<c:forEach items="${role}" varStatus="status" var="user">
	<option value="${user.getR_id()}" >${user.getR_name()}</option>
	</c:forEach>
	</select>
	</td>
</tr>
	
<tr bgcolor="white"><td align="center">性别</td>
	<td class="control"><input type="radio" name="u_sex" value="男">男
		<input type="radio" name="u_sex" value="女">女
	</td>
	<td align="center">手机号</td>
	<td class="control"><input type="text" name="u_phone" placeholder="请填写手机号"></td>

</tr>

<tr bgcolor="white"><td align="center">地址</td>
	<td class="control"><input type="text" name="u_address" placeholder="请填写地址"></td>
	<td align="center">年龄</td>
	<td class="control"><input type="text" name="u_age" placeholder="请填写年龄"></td>
</tr>

<tr bgcolor="white"><td align="center">固定电话</td>
	<td class="control"><input type="text" name="u_telphone" placeholder="请填写固定电话"></td>
	<td align="center">身份证号</td>
	<td class="control"><input type="text" name="u_idcard" placeholder="请填写身份证号"></td>
</tr>

<tr bgcolor="white">
	<td align="center">电子邮箱</td>
	<td class="control"><input type="text" name="u_mail" placeholder="请填写电子邮箱"></td>
	<td align="center">QQ号</td>
	<td class="control"><input type="text" name="u_qq" placeholder="请填写QQ号"></td>
</tr>

<tr bgcolor="white">
	<td align="center">爱好</td>
	<td class="control"><input type="text" name="u_hobby" placeholder="请填写爱好"></td>
	<td align="center">学历</td>
	<td class="control"><select name="u_edu" >
		<option value="小学">小学</option>
		<option value="初中">初中</option>
		<option value="高中">高中</option>
		<option value="大专">大专</option>
		<option value="本科">本科</option>
		<option value="研究生">研究生</option>
		<option value="博士">博士</option>
		</select>
	</td>
</tr>

<tr bgcolor="white">
	<td align="center">工资卡号</td>
	<td class="control"><input type="text" name="u_salarycard" placeholder="请填写工资卡号"></td>
	<td align="center">民族</td>
	<td class="control"><input type="text" name="u_nation" placeholder="请填写民族"></td>
</tr>

<tr bgcolor="white">
	<td align="center">婚姻状况</td>
	<td class="control"><select name="u_marry">
		<option value="未婚">未婚</option>
		<option value="已婚">已婚</option>
		<option value="离异">离异</option>
		</select>
	</td>
	<td></td>
	<td></td>
</tr>

<tr height="200px" bgcolor="white" >
	<td >备注</td>
	<td colspan="3"><textarea rows="10" cols="100" name="u_remark" placeholder="请填写备注"></textarea></td>
</tr>

</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>