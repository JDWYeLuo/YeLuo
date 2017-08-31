package com.zhiyou100.web.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.service.DepartService;
import com.zhiyou100.service.impl.DepartServiceImpl;

public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*DepartService ds = new DepartServiceImpl();*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DepartService ds = (DepartService)wac.getBean("departmentService");
		
		request.getRequestDispatcher("/WEB-INF/department/addDepartment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DepartService ds = (DepartService)wac.getBean("departmentService");
		
		String name = request.getParameter("departmentName");
		String desc = request.getParameter("departmentDesc");
		
		ds.insertDepartment(name,desc);
		response.sendRedirect(request.getContextPath()+"/depart");
	}

}

