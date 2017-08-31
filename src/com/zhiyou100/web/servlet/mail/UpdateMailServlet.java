package com.zhiyou100.web.servlet.mail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.model.Mail;
import com.zhiyou100.service.MailService;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.MailServiceImpl;
import com.zhiyou100.service.impl.UserWorkServiceImpl;

public class UpdateMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();
	UserWorkService us = new UserWorkServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		Mail m = ms.findMailById(request.getParameter("id"));
		request.setAttribute("mail", m);
		
		
		List<BeanWork> list = ms.findUser();
		request.setAttribute("users", list);
		
		
		request.getRequestDispatcher("/WEB-INF/mail/updateMail.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
