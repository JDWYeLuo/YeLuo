package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zhiyou100.dao.DepDao;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.tools.DBUtil;

public class DepDaoImpl implements DepDao {

	@Override
	public List<BeanDepartment> listDepartment(BeanDepartment de) {
		
		String sql = "insert into t_department values (null,?,?,null)";
		System.out.println(de);
		List<BeanDepartment> u = null;
		Connection con = DBUtil.getCon();
		int update = 0;
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try {
			 
			  PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, de.getD_name());
				stm.setString(2, de.getD_desc());
				update = stm.executeUpdate();
				stm.close();
				con.close();
		  if(update == 1){
			  String sql2 = "select * from t_department";
			u = qr.query(sql2, new BeanListHandler<>(BeanDepartment.class));
				
		  }
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return u;
	}
	
}


