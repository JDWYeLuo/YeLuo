package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.NoticeDao;
import com.zhiyou100.model.BeanDepartment;
import com.zhiyou100.model.BeanNotice;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.tools.DBUtil;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public int findNationCount(String noticeKeyword, String noticeFindname, BeanWork user) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_notice n left join t_department on n_departmentid = d_id left join t_user on n_userid = u_id "
				+ "where (n_departmentid = 0 or n_departmentid = ? ) and "+ noticeFindname +" like '%' ? '%'";
		long count = 0L;
		System.out.println("sql: "+sql);
		try {
		  count = qr.query(sql,new ScalarHandler<>(),user.getU_departmentid(),noticeKeyword);
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return (int)count;
	}
		
	@Override
	public List<BeanNotice> findNoticeByPage(int currentPage, String noticeKeyword, String noticeFindname, BeanWork user) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		
		String sql = "select n.*,d_name ,u_name  from t_notice n left join t_department on n_departmentid = d_id left join t_user on n_userid = u_id"
				+ " where (n_departmentid = 0 or n_departmentid = ? ) and "+ noticeFindname +" like '%' ? '%' limit ?,10";
		
		List<BeanNotice> list = null;
		try {
			  list = qr.query(sql, new BeanListHandler<>(BeanNotice.class),user.getU_departmentid(),noticeKeyword,(currentPage-1)*10);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return list;
	}

	@Override
	public void deleteNoticeById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from t_notice where n_id = ?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void putinfor(BeanNotice pe) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try{
		int a = qr.update("insert into t_notice values (null,?,?,?,?,?,?)", pe.getN_userid(),pe.getN_theme(),
				pe.getN_departmentid(),pe.getN_content(),pe.getN_begintime(),pe.getN_endtime());
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}
/*	"select n.*,d.d_name departmentName ,u.u_name userName from t_notice n , t_department d , t_user u  where n_userid = u_id and n_departmentid = d_id and n_id =?";*/
	@Override
	public BeanNotice updateNoticeById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_notice where n_id = ?";
		BeanNotice dt = null;
		try {
		   dt = qr.query(sql,new BeanHandler<>(BeanNotice.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return dt;
	}
	/* "update t_notice set n_userid = ?, n_theme = ?,n_departmentid= ?,n_content = ?, n_begintime = ?,n_endtime= ? where n_id = ?";*/
	@Override
	public void updateinfor(BeanNotice pe) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql ="update t_notice set n_theme = ? , n_departmentid =?,n_content =?,n_begintime =?,n_endtime = ? where n_id = ?";
		try {
			qr.update(sql,pe.getN_theme(),
					pe.getN_departmentid(),pe.getN_content(),
					pe.getN_begintime(),pe.getN_endtime(),pe.getN_id());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}

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
	public void addNotice(BeanNotice pe) {
		String sql = "insert into t_notice values (null,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try {
		   qr.update(sql, pe.getN_userid(),pe.getN_theme(),pe.getN_departmentid(),pe.getN_content(),pe.getN_begintime(),pe.getN_endtime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
/*	String sql = "select n.*,d_name ,u_name  from t_notice n left join t_department on
 *  n_departmentid = d_id left join t_user on n_userid = u_id"
			+ " where (n_departmentid = 0 or n_departmentid = ? ) 
			and "+ noticeFindname +" like '%' ? '%' limit ?,10";*/
	@Override
	public BeanNotice lookUserById(String id) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select n.*,d_name ,u_name  from t_notice n , t_department , t_user  where n_departmentid = d_id and n_userid = u_id and n_id =?";
		BeanNotice dt = null;
		try {
		  dt = qr.query(sql,new BeanHandler<>(BeanNotice.class),id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return dt;
	}

}
