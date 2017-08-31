package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanNotice;
import com.zhiyou100.model.BeanWork;

public interface NoticeDao {

	int findNationCount(String noticeKeyword, String noticeFindname, BeanWork user);

	List<BeanNotice> findNoticeByPage(int currentPage, String noticeKeyword, String noticeFindname, BeanWork user);

	void deleteNoticeById(String id);

	void putinfor(BeanNotice pe);

	BeanNotice updateNoticeById(String id);

	void updateinfor(BeanNotice pe);

	List<BeanDepartment> findDepart();

	void addNotice(BeanNotice pe);

	BeanNotice lookUserById(String id);

}
