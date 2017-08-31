package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.dao.impl.RoleDaoImpl;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao rd ;
	
	public RoleDao getRd() {
		return rd;
	}
	public void setRd(RoleDao rd) {
		this.rd = rd;
	}
	@Override
	public List<BeanRole> findRole() {
		
		return rd.findRole();
	}
	@Override
	public void deleteRoleById(String id) {
		
		rd.deleteRoleById( id);
		
	}
	@Override
	public void insertRole(String name, String desc) {
		
		rd.insertRole( name,  desc);
		
	}
	@Override
	public BeanRole updateRoleById(String id) {
		
		return rd.updateRoleById( id);
	}
	@Override
	public void updateRole(String name, String desc, String id) {
		rd.updateRole(name,  desc, id);
		
	}
	@Override
	public int findRoleCount() {
		
		return rd.findRoleCount();
	}
	@Override
	public List<BeanRole> findRoleByPage(int currentPage) {
		
		return rd.findRoleByPage( currentPage);
	}

}
