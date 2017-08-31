package com.zhiyou100.web.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.FindService;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.FindServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FindService  fs = new FindServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int count = fs.findtwoUserCount();
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		System.out.println("count: "+count);
		
		String keyword = request.getParameter("keyword");
		String findname = request.getParameter("findname");
		
		System.out.println("keyword: "+keyword+"-----------"+"findname: "+findname);
		List<BeanWork> user = fs.findUser(keyword, findname,currentPage);
		request.setAttribute("list", user);
		request.getRequestDispatcher("/WEB-INF/user/listUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
