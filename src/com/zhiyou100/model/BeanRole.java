package com.zhiyou100.model;

import java.sql.Timestamp;

public class BeanRole {
	private String r_id;
	private String r_name;
	private String r_desc;
	private Timestamp r_updatetime;
	
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_desc() {
		return r_desc;
	}
	public void setR_desc(String r_desc) {
		this.r_desc = r_desc;
	}
	public Timestamp getR_updatetime() {
		return r_updatetime;
	}
	public void setR_updatetime(Timestamp r_updatetime) {
		this.r_updatetime = r_updatetime;
	}
	@Override
	public String toString() {
		return "BeanRole [r_id=" + r_id + ", r_name=" + r_name + ", r_desc=" + r_desc + ", r_updatetime=" + r_updatetime
				+ "]";
	}

	
	
	
	
	
}
