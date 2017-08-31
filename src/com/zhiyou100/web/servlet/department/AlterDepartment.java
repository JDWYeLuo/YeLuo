package com.zhiyou100.web.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServiceImpl;

public class AlterDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*UserService us = new UserServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserService us = (UserService)wac.getBean("userService");
		
		String section = request.getParameter("section");
		String description = request.getParameter("description");
		
		String reult2 = us.alterDepartment(section, description);
		response.getWriter().write(reult2);
		response.sendRedirect("/Project/addSection.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
