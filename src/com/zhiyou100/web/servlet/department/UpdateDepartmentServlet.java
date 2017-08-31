package com.zhiyou100.web.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.service.DepartService;
import com.zhiyou100.service.impl.DepartServiceImpl;

public class UpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*DepartService ds = new DepartServiceImpl();*/
	/*
	 * 1. 获取id
	 * 2. 通过id查询对象
	 * 3. 对象放入request域中
	 * 4. 内部转发到update.jsp
	 * 
	 * 5.post中  修改
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DepartService ds = (DepartService)wac.getBean("departmentService");
		
		String id = request.getParameter("id");
		BeanDepartment dt = ds.updateDepartmentById(id);
		request.setAttribute("department",dt);
		request.getRequestDispatcher("/WEB-INF/department/updateDepartment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DepartService ds = (DepartService)wac.getBean("departmentService");
		
		String name = request.getParameter("departmentName");
		String desc = request.getParameter("departmentDesc");
		String id = request.getParameter("id");
		
		ds.updateDepartment(name,desc,id);
	  response.sendRedirect(request.getContextPath()+"/depart");
	
	}

}
