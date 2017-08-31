package com.zhiyou100.service;

import java.util.List;


import com.zhiyou100.model.BeanRole;

public interface RoleService {

		List<BeanRole> findRole();

		void deleteRoleById(String id);

		void insertRole(String name, String desc);

		BeanRole updateRoleById(String id);

		void updateRole(String name, String desc, String id);

		int findRoleCount();

		List<BeanRole> findRoleByPage(int currentPage);
}
