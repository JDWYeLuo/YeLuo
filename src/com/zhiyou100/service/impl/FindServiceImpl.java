package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.FindDao;
import com.zhiyou100.dao.impl.FindDaoImpl;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.FindService;

public class FindServiceImpl implements FindService {
	FindDao fd = new FindDaoImpl();

	@Override
	public List<BeanWork> findUser(String keyword, String findname, int currentPage) {
		
		return fd.findUser( keyword,  findname, currentPage);
	}

	@Override
	public int findtwoUserCount() {
		
		return fd.findtwoUserCount();
	}
	
	
	
}
