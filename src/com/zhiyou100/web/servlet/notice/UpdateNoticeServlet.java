package com.zhiyou100.web.servlet.notice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanNotice;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;

public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*NoticeService ns = new NoticeServiceImpl();*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		NoticeService ns = (NoticeService)wac.getBean("noticeService");
		
		String id = request.getParameter("id");
		
		BeanNotice dt = ns.updateNoticeById(id);
		List<BeanDepartment> depart = ns.findDepart();
		
		request.setAttribute("notice",dt);
		request.setAttribute("depart", depart);
		
		
		request.getRequestDispatcher("/WEB-INF/notice/updateNotice.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		NoticeService ns = (NoticeService)wac.getBean("noticeService");
		
		Map<String, String[]> map = request.getParameterMap();
		BeanNotice pe = new BeanNotice();
		try {
			BeanUtils.populate(pe, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ns.updateinfor(pe);
		
		
		
		response.sendRedirect(request.getContextPath()+"/listNotice");
	}

}
