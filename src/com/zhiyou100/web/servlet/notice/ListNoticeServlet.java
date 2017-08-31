package com.zhiyou100.web.servlet.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanNotice;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;
import com.zhiyou100.tools.PageInfo;

public class ListNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*NoticeService ns = new NoticeServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		NoticeService ns = (NoticeService)wac.getBean("noticeService");
		
		String noticeKeyword = request.getParameter("noticeKeyword");
		String noticeFindname = request.getParameter("noticeFindname");
		BeanWork user = (BeanWork)  request.getSession().getAttribute("user");
		if(noticeKeyword == null || noticeFindname == null){
			noticeKeyword = request.getSession().getAttribute("noticeKeyword")==null ? "":(String)request.getSession().getAttribute("noticeKeyword");
			noticeFindname = request.getSession().getAttribute("noticeFindname")==null ? "n_theme":(String)request.getSession().getAttribute("noticeFindname");
		}
		request.getSession().setAttribute("noticeKeyword", noticeKeyword);
		request.getSession().setAttribute("noticeFindname", noticeFindname);
		
		
		int currentPage = 1;
		if(request.getParameter("page")!=null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int count = ns.findNationCount(noticeKeyword,noticeFindname,user);
		PageInfo pif =  new PageInfo(currentPage, (count+9)/10,count,request.getContextPath()+request.getServletPath());
		request.setAttribute("pageInfo", pif);
		
		List<BeanNotice> list = ns.findNoticeByPage(currentPage,noticeKeyword,noticeFindname,user);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/notice/listNotice.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

