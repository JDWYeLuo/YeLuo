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

public class DraftMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	MailService ms = new MailServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		String draftMailKeyWord = request.getParameter("draftMailKeyWord");
		String draftMailSearchField = request.getParameter("draftMailSearchField");
		
		BeanWork u = (BeanWork)  request.getSession().getAttribute("user");
		
		if(draftMailKeyWord == null || draftMailSearchField == null){
			draftMailKeyWord = request.getSession().getAttribute("draftMailKeyWord")==null?"":(String)request.getSession().getAttribute("draftMailKeyWord");
			draftMailSearchField = request.getSession().getAttribute("draftMailSearchField")==null?"m_theme":(String)request.getSession().getAttribute("draftMailSearchField");
		}
		
		request.getSession().setAttribute("draftMailKeyWord", draftMailKeyWord);
		request.getSession().setAttribute("draftMailSearchField", draftMailSearchField);
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int count = ms.findDraftMailCount(draftMailKeyWord,draftMailSearchField,u);
		
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<Mail> list = ms.findDraftMail(draftMailKeyWord,draftMailSearchField,currentPage,u);
		
		request.setAttribute("list", list);
		
		
		System.out.println(count+"---"+list);
		
		request.getRequestDispatcher("/WEB-INF/mail/draftMail.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
