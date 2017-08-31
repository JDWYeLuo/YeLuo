package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.UserWorkDao;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.tools.DBUtil;

public class UserWorkDaoimpl implements UserWorkDao {

	@Override
	public List<BeanWork> findUser() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_user where u_name = ? and u_pwd = ?";
		List<BeanWork> list = null;
		try {
		  list = qr.query(sql, new BeanListHandler<>(BeanWork.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public void deleteUserById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from t_user where u_id = ?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void putinfor(BeanWork pe) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try{
		int a = qr.update("insert into t_user values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", pe.getU_name(),pe.getU_pwd(),
				pe.getU_departmentid(),pe.getU_roleid(),pe.getU_sex(),pe.getU_phone(),pe.getU_address(),pe.getU_age(),
				pe.getU_telphone(),pe.getU_idcard(),pe.getU_mail(),pe.getU_qq(),pe.getU_hobby(),pe.getU_edu(),
				pe.getU_salarycard(),pe.getU_nation(),pe.getU_marry(),pe.getU_remark(),new Timestamp(System.currentTimeMillis()));
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

		
	}

	@Override
	public BeanWork updateUserById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_user where u_id =?";
		BeanWork dt = null;
		try {
		  dt = qr.query(sql,new BeanHandler<>(BeanWork.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dt;
	}

	@Override
	public void updateinfor(BeanWork pe) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try{
			String b = "update t_user set u_name=?,u_pwd=?,u_departmentid=?,u_roleid=?,u_sex=?,u_phone=?,u_address=?,u_age=?,u_telphone=?,u_idcard=?,u_mail=?,u_qq=?,u_hobby=?,u_edu=?,u_salarycard=?,u_nation=?,u_marry=?,u_remark=?,u_updatetime=? where u_id = ?";
		int a = qr.update(b, pe.getU_name(),
				pe.getU_pwd(),pe.getU_departmentid(),pe.getU_roleid(),pe.getU_sex(),pe.getU_phone(),pe.getU_address(),pe.getU_age(),
				pe.getU_telphone(),pe.getU_idcard(),pe.getU_mail(),pe.getU_qq(),pe.getU_hobby(),pe.getU_edu(),
				pe.getU_salarycard(),pe.getU_nation(),pe.getU_marry(),pe.getU_remark(),new Timestamp(System.currentTimeMillis()),pe.getU_id());
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
}

	@Override
	public int findUserCount(String keyword,String findname) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_user u,t_department,t_role where u_departmentid=d_id and u_roleid=r_id and "
				+ findname +" like '%' ? '%'";
				
		long count = 0L;
		
		try {
		  count = qr.query(sql,new ScalarHandler<>(),keyword);
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return (int)count;
	}

	@Override
	public List<BeanWork> findUserByPage(int currentPage,String keyword,String findname) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		
		String sql = "select u.*,d_name departmentName,r_name roleName from t_user u,t_department,t_role where u_departmentid=d_id and u_roleid=r_id and "
				+ findname +" like '%' ? '%' limit ?,10";
		List<BeanWork> list = null;
		try {
		  list = qr.query(sql, new BeanListHandler<>(BeanWork.class),keyword,(currentPage-1)*10);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public BeanWork lookUserById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select u.*,d_name departmentName,r_name roleName from t_user u,t_department,t_role where u_departmentid=d_id and u_roleid=r_id and u_id =?";
		BeanWork dt = null;
		try {
		  dt = qr.query(sql,new BeanHandler<>(BeanWork.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return dt;
		
	}

	@Override
	public List<BeanDepartment> optionDepart() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_department";
		List<BeanDepartment> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(BeanDepartment.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}

	@Override
	public List<BeanRole> optionRole() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_role";
		List<BeanRole> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(BeanRole.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return list;
	}



	

	
}
