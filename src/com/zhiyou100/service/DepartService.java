package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.BeanDepartment;

public interface DepartService {
		
		List<BeanDepartment> findDepart();

		void deleteDepartmentId(String id);

		void insertDepartment(String name, String desc);

		BeanDepartment updateDepartmentById(String id);

		void updateDepartment(String name, String desc, String id);

		int findDepartCount();

		List<BeanDepartment> findDepartByPage(int currentPage);

}
