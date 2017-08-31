package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.BeanWork;

public interface FindDao {

	List<BeanWork> findUser(String keyword, String findname, int currentPage);

	int findtwoUserCount();

}
