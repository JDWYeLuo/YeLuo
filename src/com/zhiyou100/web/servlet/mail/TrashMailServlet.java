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

public class TrashMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*MailService ms = new MailServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MailService ms = (MailService)wac.getBean("mailService");
		
		String trashMailKeyWord = request.getParameter("trashMailKeyWord");
		String trashMailSearchField = request.getParameter("trashMailSearchField");
		
		BeanWork u = (BeanWork) request.getSession().getAttribute("user");
		
		if(trashMailKeyWord == null || trashMailSearchField == null){
			trashMailKeyWord = request.getSession().getAttribute("trashMailKeyWord")==null?"":(String)request.getSession().getAttribute("trashMailKeyWord");
			trashMailSearchField = request.getSession().getAttribute("trashMailSearchField")==null?"m_theme":(String)request.getSession().getAttribute("trashMailSearchField");
		}
		
		request.getSession().setAttribute("trashMailKeyWord", trashMailKeyWord);
		request.getSession().setAttribute("trashMailSearchField", trashMailSearchField);
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int count = ms.findTrashMailCount(trashMailKeyWord,trashMailSearchField,u);
		
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<Mail> list = ms.findTrashMail(trashMailKeyWord,trashMailSearchField,currentPage,u);
		
		request.setAttribute("list", list);
		System.out.println(count+"---");
		request.getRequestDispatcher("/WEB-INF/mail/trashMail.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
