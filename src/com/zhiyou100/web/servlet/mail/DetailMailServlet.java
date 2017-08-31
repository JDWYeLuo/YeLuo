package com.zhiyou100.web.servlet.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.Mail;
import com.zhiyou100.service.MailService;
import com.zhiyou100.service.impl.MailServiceImpl;

public class DetailMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		Mail m = ms.findMailById(request.getParameter("id"));
		request.setAttribute("mail", m);
		
		request.getRequestDispatcher("/WEB-INF/mail/detailMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
