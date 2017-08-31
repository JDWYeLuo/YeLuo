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

public class ReceiveMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		String receiveMailKeyWord = request.getParameter("receiveMailKeyWord");
		String receiveMailSearchField = request.getParameter("receiveMailSearchField");
		if(receiveMailKeyWord == null || receiveMailSearchField == null){
			receiveMailKeyWord = request.getSession().getAttribute("receiveMailKeyWord")==null?"":(String)request.getSession().getAttribute("receiveMailKeyWord");
			receiveMailSearchField = request.getSession().getAttribute("receiveMailSearchField")==null?"m_theme":(String)request.getSession().getAttribute("receiveMailSearchField");
		}
		
		request.getSession().setAttribute("receiveMailKeyWord", receiveMailKeyWord);
		request.getSession().setAttribute("receiveMailSearchField", receiveMailSearchField);
		
		int currentPage = request.getParameter("page")==null? 1:Integer.parseInt(request.getParameter("page"));
		
		BeanWork u = (BeanWork)  request.getSession().getAttribute("user");
		int count = ms.findReceiveMailCount(receiveMailKeyWord,receiveMailSearchField,u);
		
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<Mail> list = ms.findReceiveMail(receiveMailKeyWord,receiveMailSearchField,currentPage,u);
		
		request.setAttribute("list", list);
		
		
		System.out.println(count+"66666");
		System.out.println(list+"77777");
		request.getRequestDispatcher("/WEB-INF/mail/receiveMail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
