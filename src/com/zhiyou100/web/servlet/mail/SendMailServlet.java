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
import com.zhiyou100.service.impl.MailServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		String mailKeyword = request.getParameter("mailKeyword");
		String mailFindname = request.getParameter("mailFindname");
		
		BeanWork u = (BeanWork)  request.getSession().getAttribute("user");
		
		
		if(mailKeyword == null || mailFindname == null){
			mailKeyword = request.getSession().getAttribute("mailKeyword")==null ? "":(String)request.getSession().getAttribute("mailKeyword");
			mailFindname = request.getSession().getAttribute("mailFindname")==null ? "m_theme":(String)request.getSession().getAttribute("mailFindname");
		}
		request.getSession().setAttribute("mailKeyword", mailKeyword);
		request.getSession().setAttribute("mailFindname", mailFindname);
		
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int count = ms.findMailCount(mailKeyword,mailFindname,u);
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<Mail> list = ms.sendMailPage(currentPage,mailKeyword,mailFindname,u);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/mail/sendMail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
