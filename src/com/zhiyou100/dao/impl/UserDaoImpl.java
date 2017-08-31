package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.tools.DBUtil;



public  class UserDaoImpl implements UserDao {

	@Override
	public BeanWork loginUser(String username, String password) {
		
	QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		
		String sql = "select * from t_user where u_name = ? and u_pwd = ?";	
		BeanWork query = null;
		   try {
			query = qr.query(sql, new BeanHandler<>(BeanWork.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return query;
	}

	@Override
	public String alterDepartment(String section, String description) {
		Connection con = DBUtil.getCon();
		String resultStr = null;
	String sql1 = "select * from t_department where d_name = ?";
		try{
			System.out.println("777777");
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, section);
			ResultSet resultSet = stm.executeQuery();
			System.out.println("05");
			
			if(resultSet.next()){
				System.out.println("07");
				resultStr = "部门添加失败";
			}else{
				String sql2 = "insert into t_department values (null,?,?,null)";
				stm = con.prepareStatement(sql2);
				stm.setString(1, section);
				stm.setString(2, description);
				stm.executeUpdate();
				System.out.println(section);
				System.out.println(description);
				resultStr = "部门添加成功";
			}
				resultSet.close();
				stm.close();
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	
	
	
	
}

	

