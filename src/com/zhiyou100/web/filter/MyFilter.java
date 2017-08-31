package com.zhiyou100.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserService;

public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("不放行");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		UserService us = (UserService)wac.getBean("userService");
		
		
		/*HttpSession ses = req.getSession();*/
		
		
		/*req.getSession().getAttribute(user);*/
		if(req.getServletPath().equals("/index.jsp")||req.getServletPath().equals("/login")){
			chain.doFilter(request, response);
			return;
		}
		BeanWork u = (BeanWork)  req.getSession().getAttribute("user");
		if(u == null){
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			/*req.getRequestDispatcher("/index.jsp").forward(request, response);*/
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
