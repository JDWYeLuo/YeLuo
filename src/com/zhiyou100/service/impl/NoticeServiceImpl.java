package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.NoticeDao;
import com.zhiyou100.dao.impl.NoticeDaoImpl;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanNotice;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	NoticeDao nd;
	

	public NoticeDao getNd() {
		return nd;
	}

	public void setNd(NoticeDao nd) {
		this.nd = nd;
	}

	@Override
	public int findNationCount(String noticeKeyword, String noticeFindname, BeanWork user) {
		
		return nd.findNationCount( noticeKeyword,  noticeFindname, user);
	}

	@Override
	public List<BeanNotice> findNoticeByPage(int currentPage, String noticeKeyword, String noticeFindname, BeanWork user) {
		
		return nd.findNoticeByPage( currentPage,  noticeKeyword,  noticeFindname, user);
	}

	@Override
	public void deleteNoticeById(String id) {
		nd.deleteNoticeById( id);
		
	}

	@Override
	public void putinfor(BeanNotice pe) {
		
		nd.putinfor( pe);
	}

	@Override
	public BeanNotice updateNoticeById(String id) {
		
		return nd.updateNoticeById( id);
	}

	@Override
	public void updateinfor(BeanNotice pe) {
		nd.updateinfor( pe);
		
	}

	@Override
	public List<BeanDepartment> findDepart() {
		
		return nd.findDepart();
	}

	@Override
	public void addNotice(BeanNotice pe) {
		nd.addNotice( pe);
		
	}

	@Override
	public BeanNotice lookUserById(String id) {
		
		return nd.lookUserById( id);
	}
		
}
