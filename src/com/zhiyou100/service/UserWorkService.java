package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.model.BeanWork;

public interface UserWorkService {
		
	List<BeanWork> findUser();

	void deleteUserById(String id);


	void putinfor(BeanWork pe);

	BeanWork updateUserById(String id);

	void updateinfor(BeanWork pe);

	int findUserCount(String keyword,String findname);

	List<BeanWork> findUserByPage(int currentPage,String keyword,String findname);

	BeanWork lookUserById(String id);

	List<BeanDepartment> optionDepart();

	List<BeanRole> optionRole();
}
