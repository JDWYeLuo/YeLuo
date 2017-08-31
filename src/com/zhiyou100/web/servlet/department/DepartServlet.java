package com.zhiyou100.web.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.service.DepartService;
import com.zhiyou100.service.impl.DepartServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		/*DepartService ds = new DepartServiceImpl();*/
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DepartService ds = (DepartService)wac.getBean("departmentService");
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int count = ds.findDepartCount();
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
	
		List<BeanDepartment> depart = ds.findDepartByPage(currentPage);
		System.out.println(depart);
		
		request.setAttribute("list", depart);
		request.getRequestDispatcher("/WEB-INF/department/departmentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

