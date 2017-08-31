package com.zhiyou100.web.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;

public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*RoleService rs = new RoleServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		RoleService rs = (RoleService)wac.getBean("roleService");
		
		request.getRequestDispatcher("/WEB-INF/role/addRole.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		RoleService rs = (RoleService)wac.getBean("roleService");
		
		String name = request.getParameter("roleName");
		String desc = request.getParameter("roleDesc");
		
		rs.insertRole(name,desc);
		response.sendRedirect(request.getContextPath()+"/listRole");

	}

}
