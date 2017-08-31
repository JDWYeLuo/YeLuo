package com.zhiyou100.web.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;

public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*NoticeService ns = new NoticeServiceImpl();*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		NoticeService ns = (NoticeService)wac.getBean("noticeService");
		
		String id = request.getParameter("id");
		
		ns.deleteNoticeById(id);
		
		response.sendRedirect(request.getContextPath()+"/listNotice");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
