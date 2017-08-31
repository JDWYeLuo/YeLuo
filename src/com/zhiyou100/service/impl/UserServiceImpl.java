package com.zhiyou100.service.impl;


import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao  ud ;
	
	
	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
	
	@Override
	public BeanWork loginUser(String username, String password) {
		return ud.loginUser(username,password);
	}

	@Override
	public String alterDepartment(String section, String description) {
		
		
		return ud.alterDepartment(section, description);
	}
	
	
	
}
