package com.zhiyou100.model;

import java.sql.Timestamp;

public class BeanDepartment {
	
	private String d_id;
	private String d_name;
	private String d_desc;
	private Timestamp d_updatetime;
	
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_desc() {
		return d_desc;
	}
	public void setD_desc(String d_desc) {
		this.d_desc = d_desc;
	}
	public Timestamp getD_updatetime() {
		return d_updatetime;
	}
	public void setD_updatetime(Timestamp d_updatetime) {
		this.d_updatetime = d_updatetime;
	}
	@Override
	public String toString() {
		return "BeanDepartment [d_id=" + d_id + ", d_name=" + d_name + ", d_desc=" + d_desc + ", d_updatetime="
				+ d_updatetime + "]";
	}
	
	
	
	
	
	
}
