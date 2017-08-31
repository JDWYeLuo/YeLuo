package com.zhiyou100.web.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanRole;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class ListRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*RoleService rs = new RoleServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		RoleService rs = (RoleService)wac.getBean("roleService");
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		/*
		 * 1.查询总条数,因为需要查询Department表中的所有信息,所以没有条件的
		 * 2.计算总页数
		 */
		int count = rs.findRoleCount();
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<BeanRole> rol = rs.findRoleByPage(currentPage);
		request.setAttribute("list", rol);
		
		request.getRequestDispatcher("/WEB-INF/role/listRole.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
