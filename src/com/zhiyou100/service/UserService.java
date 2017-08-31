package com.zhiyou100.service;

import com.zhiyou100.model.BeanWork;

public interface UserService {
	
	BeanWork loginUser(String username, String password);
	
	String alterDepartment(String section, String description);
	
	
}
