package com.zhiyou100.web.servlet.mail;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.service.MailService;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.MailServiceImpl;

public class DeleteMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		String status = request.getParameter("status");
		String id = request.getParameter("id");
		
		ms.changeMailStatus(status,id);
		response.sendRedirect(request.getHeader("Referer"));
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
