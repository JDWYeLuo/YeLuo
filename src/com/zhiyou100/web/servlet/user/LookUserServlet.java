package com.zhiyou100.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.UserWorkServiceImpl;

public class LookUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserWorkService us = new UserWorkServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		String id = request.getParameter("id");
		BeanWork dt =us.lookUserById(id);
		request.setAttribute("user",dt);
	
		request.getRequestDispatcher("/WEB-INF/user/lookUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}