package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.DepartDao;
import com.zhiyou100.dao.impl.DepartDaoImpl;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.service.DepartService;

public class DepartServiceImpl implements DepartService {
	DepartDao dd ;
	
	public DepartDao getDd() {
		return dd;
	}
	public void setDd(DepartDao dd) {
		this.dd = dd;
	}
	
	@Override
	public List<BeanDepartment> findDepart() {
		return dd.findDepart();
	}
	@Override
	public void deleteDepartmentId(String id) {
		dd.deleteDepartmentId(id);
	}
	@Override
	public void insertDepartment(String name, String desc) {
		dd.insertDepartment( name, desc);
		
	}
	@Override
	public BeanDepartment updateDepartmentById(String id) {
		
		return dd.updateDepartmentById(id);
	}
	@Override
	public void updateDepartment(String name, String desc,String id) {
		dd.updateDepartment(name,  desc,id);
		
	}
	@Override
	public int findDepartCount() {
		
		return dd.findDepartCount();
	}
	@Override
	public List<BeanDepartment> findDepartByPage(int currentPage) {
		
		return dd.findDepartByPage( currentPage);
	}

}
