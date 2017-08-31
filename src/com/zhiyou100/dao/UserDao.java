package com.zhiyou100.dao;

import com.zhiyou100.model.BeanWork;

public interface UserDao {

	BeanWork loginUser(String username, String password);
	
	String alterDepartment(String section, String description);
	
}
