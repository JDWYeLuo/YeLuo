package com.zhiyou100.web.servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.UserWorkServiceImpl;

public class AnnUserService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserWorkService us = new UserWorkServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		List<BeanDepartment> depart = us.optionDepart();
		List<BeanRole> role = us.optionRole();
		request.setAttribute("depart", depart);
		request.setAttribute("role", role);
		
		request.getRequestDispatcher("/WEB-INF/user/addUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, String[]> map = request.getParameterMap();
		BeanWork pe = new BeanWork();
		try {
			BeanUtils.populate(pe, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		us.putinfor(pe);
	
		
		response.sendRedirect(request.getContextPath()+"/listUser");
	}

}
