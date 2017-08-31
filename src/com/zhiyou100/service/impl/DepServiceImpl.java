package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.DepDao;
import com.zhiyou100.dao.impl.DepDaoImpl;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.service.DepService;

public class DepServiceImpl implements DepService {

	DepDao ud = new DepDaoImpl();
	
	@Override
	public List<BeanDepartment> listDepartment(BeanDepartment de) {
		
		return ud.listDepartment(de);
	}

}
