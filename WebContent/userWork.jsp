<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页 - 智游客户关系管理系统</title>
<h1>新增用户</h1>
</head>
<body>
<form action="${pageContext.request.contextPath }/login">
<table  width="1200px" height="550px" cellspacing="1px" bgcolor="black">
<caption><h2></h2></caption>
<tr bgcolor="white"><td align="center">用户名</td>
	<td><input type="text" name="username" placeholder="请填写用户名"></td>
	<td align="center">密码</td>
	<td><input type="password" name="password" placeholder="请填写密码"></td>
</tr>

<tr bgcolor="white"><td align="center">部门</td>
	<td><select name="branch" >
		<option value="行政部">行政部</option>
		<option value="运营部">运营部</option>
		<option value="教学部">教学部</option>
		<option value="人事部">人事部</option>
		</select>
	</td>
	<td align="center">角色</td>
	<td><select name="part" >
		<option value="教师">教师</option>
		<option value="班主任">班主任</option>
		<option value="校长">校长</option>
		<option value="教学主任">教学主任</option>
		</select>
	</td>
</tr>
<tr bgcolor="white"><td align="center">性别</td>
	<td><input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
	</td>
	<td align="center">手机号</td>
	<td><input type="text" name="phone" placeholder="请填写手机号"></td>

</tr>

<tr bgcolor="white"><td align="center">地址</td>
	<td><input type="text" name="place" placeholder="请填写地址"></td>
	<td align="center">年龄</td>
	<td><input type="text" name="age" placeholder="请填写年龄"></td>
</tr>

<tr bgcolor="white"><td align="center">固定电话</td>
	<td><input type="text" name="telephone" placeholder="请填写固定电话"></td>
	<td align="center">身份证号</td>
	<td><input type="text" name="idCard" placeholder="请填写身份证号"></td>
</tr>

<tr bgcolor="white">
	<td align="center">电子邮箱</td>
	<td><input type="text" name="email" placeholder="请填写电子邮箱"></td>
	<td align="center">QQ号</td>
	<td><input type="text" name="qq" placeholder="请填写QQ号"></td>
</tr>

<tr bgcolor="white">
	<td align="center">爱好</td>
	<td><input type="text" name="like" placeholder="请填写爱好"></td>
	<td align="center">学历</td>
	<td><select name="study" >
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
	<td><input type="text" name="salary" placeholder="请填写工资卡号"></td>
	<td align="center">民族</td>
	<td><input type="text" name="nation" placeholder="请填写民族"></td>
</tr>

<tr bgcolor="white">
	<td align="center">婚姻状况</td>
	<td><select name="gam">
		<option value="离异">离异</option>
		<option value="未婚">未婚</option>
		<option value="已婚">已婚</option>
		</select>
	</td>
	<td></td>
	<td></td>
</tr>

<tr height="200px" bgcolor="white" >
	<td >备注</td>
	<td colspan="3"><textarea rows="10" cols="100" name="beizhu"></textarea></td>
</tr>




</table>
<input type="submit" value="保存" >
<a href="javascript:history.go(-1)"><input type="button" value="返回" ></a>
</form>
</body>
</html>