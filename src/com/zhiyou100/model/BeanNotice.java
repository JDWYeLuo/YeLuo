package com.zhiyou100.model;

import java.sql.Timestamp;


public class BeanNotice {

		private String n_id;
		private int    n_userid;
		private String n_theme;
		private int    n_departmentid;
		private String n_content;
		private Timestamp n_begintime;
		private Timestamp n_endtime;
		
		private String d_name;
		private String u_name;

		
		public String getN_id() {
			return n_id;
		}
		public void setN_id(String n_id) {
			this.n_id = n_id;
		}
		public int getN_userid() {
			return n_userid;
		}
		public void setN_userid(int n_userid) {
			this.n_userid = n_userid;
		}
		public String getN_theme() {
			return n_theme;
		}
		public void setN_theme(String n_theme) {
			this.n_theme = n_theme;
		}
		public int getN_departmentid() {
			return n_departmentid;
		}
		public void setN_departmentid(int n_departmentid) {
			this.n_departmentid = n_departmentid;
		}
		public String getN_content() {
			return n_content;
		}
		public void setN_content(String n_content) {
			this.n_content = n_content;
		}
		
		public Timestamp getN_begintime() {
			return n_begintime;
		}
		public void setN_begintime(Timestamp n_begintime) {
			this.n_begintime = n_begintime;
		}
		public Timestamp getN_endtime() {
			return n_endtime;
		}
		public void setN_endtime(Timestamp n_endtime) {
			this.n_endtime = n_endtime;
		}
		public String getD_name() {
			return d_name;
		}
		public void setD_name(String d_name) {
			this.d_name = d_name;
		}
		public String getU_name() {
			return u_name;
		}
		public void setU_name(String u_name) {
			this.u_name = u_name;
		}
		@Override
		public String toString() {
			return "BeanNotice [n_id=" + n_id + ", n_userid=" + n_userid + ", n_theme=" + n_theme + ", n_departmentid="
					+ n_departmentid + ", n_content=" + n_content + ", n_begintime=" + n_begintime + ", n_endtime="
					+ n_endtime + ", d_name=" + d_name + ", u_name=" + u_name + "]";
		}
		
		
		
		
		
		
		
		
		
	
	
	
}
