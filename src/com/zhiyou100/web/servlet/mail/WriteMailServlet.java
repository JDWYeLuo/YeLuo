package com.zhiyou100.web.servlet.mail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanWork;
import com.zhiyou100.model.Mail;
import com.zhiyou100.service.MailService;
import com.zhiyou100.service.UserWorkService;
import com.zhiyou100.service.impl.MailServiceImpl;
import com.zhiyou100.service.impl.UserWorkServiceImpl;

public class WriteMailServlet extends HttpServlet {
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
		
		List<BeanWork> list = ms.findUser();
		request.setAttribute("theUser", list);
		System.out.println("servlet----"+list);
		
		/*BeanWork userv = (BeanWork)request.getSession().getAttribute("user");
		System.out.println(userv.getU_id());*/
		
		request.getRequestDispatcher("/WEB-INF/mail/writeMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		UserWorkService us = (UserWorkService)wac.getBean("userWorkService");
		
		Mail pe = new Mail();
		
		try {
			BeanUtils.populate(pe, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("pe00000"+pe);
		if(pe.getM_id() == 0){
			//发送新的邮件
			ms.writeMail(pe);
		}else{
			//修改邮件
			ms.updateMail(pe);
		}
		
		
		response.sendRedirect(request.getContextPath()+"/sendMail");
		/*response.sendRedirect( m_receivestatus == 1? "request.getContextPath()+'/sendMail' " : "request.getContextPath()+'/draftMail' ");*/
		
	}

}
