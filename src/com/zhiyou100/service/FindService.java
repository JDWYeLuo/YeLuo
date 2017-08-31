package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.BeanWork;

public interface FindService {

	List<BeanWork> findUser(String keyword, String findname, int currentPage);

	int findtwoUserCount();

}
