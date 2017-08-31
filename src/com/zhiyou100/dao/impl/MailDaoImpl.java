package com.zhiyou100.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhiyou100.dao.MailDao;
import com.zhiyou100.model.BeanWork;
import com.zhiyou100.model.Mail;
import com.zhiyou100.tools.DBUtil;

public class MailDaoImpl implements MailDao {

	@Override
	public List<BeanWork> findUser() {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from t_user";
		List<BeanWork> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(BeanWork.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		/*System.out.println("123:"+list);*/
		return list;
	}

	@Override
	public void writeMail(Mail pe) {
		String sql = "insert into t_mail values (null,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try {
		  qr.update(sql,pe.getM_sendid(),pe.getM_receiveid(),pe.getM_theme(),pe.getM_content(),
				 new Timestamp(System.currentTimeMillis()),pe.getM_sendstatus(),pe.getM_receivestatus());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int findMailCount(String mailKeyword, String mailFindname, BeanWork u) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		String sql = "select count(*) from t_mail , t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_sendid = ? and m_sendstatus = 1 and "
				+mailFindname +" like '%' ? '%'";
		long count = 0L;
		/*System.out.println("sqlMail: "+sql);*/
		try {
		  count = qr.query(sql,new ScalarHandler<>(),u.getU_id(),mailKeyword);
		 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return (int)count;
	}

	@Override
	public List<Mail> sendMailPage(int currentPage, String mailKeyword, String mailFindname, BeanWork u) {
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		
		String sql =  "select m.*,a.u_name sendName, b.u_name receiveName from t_mail m, t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_sendid = ? and  m_sendstatus = 1 and "
				+mailFindname +" like '%' ? '%' limit ?,10";
		System.out.println(sql);
		List<Mail> list = null;
		try {
			  list = qr.query(sql, new BeanListHandler<>(Mail.class),u.getU_id(),mailKeyword,(currentPage-1)*10);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			/*System.out.println(list);*/
			
			return list;
	}

	@Override
	public int findReceiveMailCount(String receiveMailKeyWord, String receiveMailSearchField, BeanWork u) {
		String sql = "select count(*) from t_mail , t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_receiveid = ? and m_receivestatus = 1 and "
				+receiveMailSearchField +" like '%' ? '%'";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		long count = 0L;
		try {
			count = qr.query(sql, new ScalarHandler<>(), u.getU_id() ,receiveMailKeyWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*System.out.println("countMailImpl: "+count);*/
		return (int)count;
	}

	@Override
	public List<Mail> findReceiveMail(String receiveMailKeyWord, String receiveMailSearchField, int currentPage,
			BeanWork u) {
		String sql = "select m.*,a.u_name sendName, b.u_name receiveName from t_mail m, t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_receiveid = ? and  m_receivestatus = 1 and "
				+receiveMailSearchField +" like '%' ? '%' limit ?,10";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		List<Mail> li = null;
		try {
				li = qr.query(sql, new BeanListHandler<>(Mail.class),u.getU_id(),receiveMailKeyWord,(currentPage-1)*10);
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		return li;
	}

	@Override
	public int findDraftMailCount(String draftMailKeyWord, String draftMailSearchField, BeanWork u) {
		String sql = "select count(*) from t_mail , t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_sendid = ?  and  m_sendstatus = 2 and "
				+draftMailSearchField +" like '%' ? '%'";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		long count = 0L;
		try {
			count = qr.query(sql, new ScalarHandler<>(), u.getU_id() ,draftMailKeyWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int)count;
	}

	@Override
	public List<Mail> findDraftMail(String draftMailKeyWord, String draftMailSearchField, int currentPage, BeanWork u) {
		String sql = "select m.*,a.u_name sendName, b.u_name receiveName from t_mail m, t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_sendid = ? and  m_sendstatus = 2 and "
				+draftMailSearchField +" like '%' ? '%' limit ?,10";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		List<Mail> li = null;
		try {
				li = qr.query(sql, new BeanListHandler<>(Mail.class),u.getU_id(),draftMailKeyWord,(currentPage-1)*10);
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		return li;
	}

	@Override
	public int findTrashMailCount(String trashMailKeyWord, String trashMailSearchField, BeanWork u) {
		String sql = "select count(*) from t_mail left join  t_user a "
				+ " on m_sendid = a.u_id left join t_user b  on m_receiveid = b.u_id  "
				+ "  where  (( m_sendid = ?  and  m_sendstatus = 3 ) or (m_receiveid=  "
				+ "  ? and m_receivestatus = 2 )) and "
				+trashMailSearchField +" like '%' ? '%'";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		long count = 0L;
		try {
			count = qr.query(sql, new ScalarHandler<>(), u.getU_id() ,u.getU_id(),trashMailKeyWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int)count;
}
			//发送端状态 1.发送       2.草稿	    3.垃圾箱		4.删除
			//接收端状态 1.接收	  2.垃圾箱	3.删除
	
	@Override
	public List<Mail> findTrashMail(String trashMailKeyWord, String trashMailSearchField, int currentPage, BeanWork u) {
		String sql = "select m.*,a.u_name sendName, b.u_name receiveName from "
				+ " t_mail m left join t_user a on m_sendid = a.u_id left join "
				+ " t_user b  on m_receiveid = b.u_id  where  (( m_sendid = ?  and "
				+ " m_sendstatus = 3 ) or (m_receiveid= ? and m_receivestatus = 2 )) and "
				+trashMailSearchField +" like '%' ? '%' limit ?,10";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		List<Mail> li = null;
		try {
				li = qr.query(sql, new BeanListHandler<>(Mail.class),u.getU_id(),u.getU_id(),trashMailKeyWord,(currentPage-1)*10);
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		return li;
	}

	@Override
	public void changeMailStatus(String status, String id) {
		String sql = "update t_mail set "+status+" where m_id = ?";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try {
		   qr.update(sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMail(Mail pe) {
		String sql = "update t_mail set m_sendid=?,m_receiveid=?,m_theme=?,m_content=?,m_sendtime=?,m_sendstatus=?,m_receivestatus=? where m_id=?";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		try {
		   qr.update(sql,pe.getM_sendid(),pe.getM_receiveid(),pe.getM_theme(),pe.getM_content(),new Timestamp(System.currentTimeMillis()),pe.getM_sendstatus(),pe.getM_receivestatus(),pe.getM_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Mail findMailById(String id) {
		String sql = "select m.*,a.u_name sendName, b.u_name receiveName from t_mail m, t_user a,t_user b where m_sendid = a.u_id and m_receiveid = b.u_id  and m_id = ?";
		QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
		Mail m = null;
		try {
				m = qr.query(sql, new BeanHandler<>(Mail.class),id);
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		return m;
	}

}
