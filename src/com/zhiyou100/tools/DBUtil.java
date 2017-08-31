package com.zhiyou100.tools;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
	
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		
		return dataSource;
	}
	
	
	
	public static Connection getCon(){
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
