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
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.UserWorkServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*UserWorkService us = new UserWorkServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		String keyword = request.getParameter("keyword");
		String findname = request.getParameter("findname");
		
		if(keyword == null || findname == null){
			keyword = request.getSession().getAttribute("keyword")==null ? "":(String)request.getSession().getAttribute("keyword");
			findname = request.getSession().getAttribute("findname")==null ? "u_name":(String)request.getSession().getAttribute("findname");
		}
		
		request.getSession().setAttribute("keyword", keyword);
		request.getSession().setAttribute("findname", findname);
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int count = us.findUserCount(keyword,findname);
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		
		List<BeanWork> list = us.findUserByPage(currentPage,keyword,findname);
		
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("/WEB-INF/user/listUser.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
