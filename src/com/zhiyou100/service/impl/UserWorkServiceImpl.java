package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.UserWorkDao;
import com.zhiyou100.dao.impl.UserWorkDaoimpl;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.service.UserWorkService;

public class UserWorkServiceImpl implements UserWorkService {
	UserWorkDao ud ;
	
	public UserWorkDao getUd() {
		return ud;
	}
	public void setUd(UserWorkDao ud) {
		this.ud = ud;
	}
	@Override
	public List<BeanWork> findUser() {
		
		return ud.findUser();
	}
	@Override
	public void deleteUserById(String id) {
		
		ud.deleteUserById(id);
	}
	@Override
	public void putinfor(BeanWork pe) {
		
	 ud.putinfor(pe);
	}
	@Override
	public BeanWork updateUserById(String id) {
		
		return ud.updateUserById(id);
	}
	@Override
	public void updateinfor(BeanWork pe) {
		
		ud.updateinfor( pe);
		
	}
	@Override
	public int findUserCount(String keyword,String findname) {
		
		return ud.findUserCount(keyword,findname);
	}
	@Override
	public List<BeanWork> findUserByPage(int currentPage,String keyword,String findname) {
		
		return ud.findUserByPage( currentPage,keyword,findname);
	}
	@Override
	public BeanWork lookUserById(String id) {
		
		return ud.lookUserById(id);
	}
	@Override
	public List<BeanDepartment> optionDepart() {
		
		return ud.optionDepart();
	}
	@Override
	public List<BeanRole> optionRole() {
		
		return ud.optionRole();
	}
	
	
}
