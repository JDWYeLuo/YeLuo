package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.model.BeanRole;
import com.zhiyou100.tools.DBUtil;

public class RoleDaoImpl implements RoleDao {

	@Override
	public List<BeanRole> findRole() {
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

	@Override
	public void deleteRoleById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from t_role where r_id = ?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertRole(String name, String desc) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into t_role values (null,?,?,?)";
		try {
			qr.update(sql, name,desc,new Timestamp(System.currentTimeMillis()));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public BeanRole updateRoleById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_role where r_id = ?";
		BeanRole dt = null;
		try {
		  dt = qr.query(sql,new BeanHandler<>(BeanRole.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dt;
	}

	@Override
	public void updateRole(String name, String desc, String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "update t_role set r_name = ?, r_desc = ?,r_updatetime= ? where r_id = ?";
		try {
			qr.update(sql,name,desc,new Timestamp(System.currentTimeMillis()), id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}

	@Override
	public int findRoleCount() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_role";
		int count = 0;
		try {
		  long  count1 = qr.query(sql,new ScalarHandler<>());
		  count = (int)count1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return count;
	}

	@Override
	public List<BeanRole> findRoleByPage(int currentPage) {
		//查询department中所有的数据
		//QueryRunner是一个工具,这个工具是用来执行sql语句的,创建的时候给一个连接池,那么当qr执行sql语句的时候
		//会自动去连接池中获取连接
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		//第一个值表示 从第几条开始(不包括这一条),第二个值表示一页显示多少条
		String sql = "select * from t_role limit ?,10";
		List<BeanRole> list = null;
		try {
		  list = qr.query(sql, new BeanListHandler<>(BeanRole.class),(currentPage-1)*10);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	
	
	
	
	
	
	
}
