package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.FindDao;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.tools.DBUtil;

public class FindDaoImpl implements FindDao {

	@Override
	public List<BeanWork>  findUser(String keyword, String findname, int currentPage) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		/*
		 * 1.模糊查询      %?%
		 * 2.关键字查询
		 */
		System.out.println("keywordImpl: "+keyword);
		System.out.println("findnameImpl: "+findname);
		List<BeanWork> dt = null;
	
		String sql = "select u.*,d_name ,r_name  from t_user u,t_department,t_role where u_departmentid = d_id and u_roleid = r_id and "+
				findname+" like '%' ? '%' limit ?,10 ";
		
		try {
		  dt = qr.query(sql,new BeanListHandler<>(BeanWork.class),keyword,(currentPage-1)*10);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("dt: "+dt);
		return dt;
		
		
		
		/*try {
			
			if("用户名".equals(findname)){
				String sql = "select u.*,d_name ,r_name  from t_user u,t_department,t_role where u_departmentid = d_id and u_roleid = r_id and u_name like '%' ? '%' limit ?,10 ";
				System.out.println(sql);
				dt = qr.query(sql,new BeanListHandler<>(BeanWork.class), keyword,(currentPage-1)*10);
				System.out.println(dt);
			}
			if("手机号".equals(findname)){
				String sql = "select * from t_user  where u_phone like '%' ? '%' limit ?,10";
				dt = qr.query(sql,new BeanListHandler<>(BeanWork.class), keyword,(currentPage-1)*10);
			}
			if("地址".equals(findname)){
				String sql = "select * from t_user  where u_address like '%' ? '%' limit ?,10";
				 dt =  qr.query(sql,new BeanListHandler<>(BeanWork.class), keyword,(currentPage-1)*10);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  dt;*/
		
}

	@Override
	public int findtwoUserCount() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_user ";
		int count = 0;
		try {
		  long  count1 = qr.query(sql,new ScalarHandler<>());
		  count = (int)count1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return count;
	}

	

}
