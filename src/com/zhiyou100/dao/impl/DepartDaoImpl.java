package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.DepartDao;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.tools.DBUtil;

public class DepartDaoImpl implements DepartDao {

	@Override
	public List<BeanDepartment> findDepart() {
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
	public void deleteDepartmentId(String id) {
		
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from t_department where d_id = ?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void insertDepartment(String name, String desc) {
		
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into t_department values (null,?,?,?)";
		try {
			qr.update(sql, name,desc,new Timestamp(System.currentTimeMillis()));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public BeanDepartment updateDepartmentById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_department where d_id = ?";
		BeanDepartment dt = null;
		try {
		  dt = qr.query(sql,new BeanHandler<>(BeanDepartment.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dt;
	}

	@Override
	public void updateDepartment(String name, String desc, String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "update t_department set d_name = ?, d_desc = ?,d_updatetime= ? where d_id = ?";
		try {
			qr.update(sql,name,desc,new Timestamp(System.currentTimeMillis()), id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int findDepartCount() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_department";
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
	public List<BeanDepartment> findDepartByPage(int currentPage) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		
		String sql = "select * from t_department limit ?,10";
		List<BeanDepartment> list = null;
		try {
		  list = qr.query(sql, new BeanListHandler<>(BeanDepartment.class),(currentPage-1)*10);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}
		
	
	
	}

