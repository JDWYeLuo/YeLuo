package com.zhiyou100.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*UserService us = new UserServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserService us = (UserService)wac.getBean("userService");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BeanWork reult = us.loginUser(username, password);
		
		
		if(reult==null){
			request.setAttribute("index","登录失败");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.getSession().setAttribute("user", reult);
			response.sendRedirect(request.getContextPath()+"/admin.jsp");
		}
	//<a href="javascript:history.go(-1)">返回</a>

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
