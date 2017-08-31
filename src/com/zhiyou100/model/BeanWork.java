package com.zhiyou100.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class BeanWork implements HttpSessionActivationListener,Serializable{
	
	private int u_id;
	private String u_name;
	private String u_pwd;
	private int u_departmentid;
	private int u_roleid;
	private String u_sex;
	private String u_phone;
	private String u_address;
	private int u_age;
	private String u_telphone;
	private String u_idcard;
	
	private String u_mail;
	private String u_qq;
	
	private String u_hobby;
	private String u_edu;
	
	private String u_salarycard;
	private String u_nation;
	
	private String u_marry;
	private String u_remark;
	private Timestamp u_updatetime;
	
	private String departmentName;
	private String roleName;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public int getU_departmentid() {
		return u_departmentid;
	}
	public void setU_departmentid(int u_departmentid) {
		this.u_departmentid = u_departmentid;
	}
	public int getU_roleid() {
		return u_roleid;
	}
	public void setU_roleid(int u_roleid) {
		this.u_roleid = u_roleid;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_telphone() {
		return u_telphone;
	}
	public void setU_telphone(String u_telphone) {
		this.u_telphone = u_telphone;
	}
	public String getU_idcard() {
		return u_idcard;
	}
	public void setU_idcard(String u_idcard) {
		this.u_idcard = u_idcard;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public String getU_qq() {
		return u_qq;
	}
	public void setU_qq(String u_qq) {
		this.u_qq = u_qq;
	}
	public String getU_hobby() {
		return u_hobby;
	}
	public void setU_hobby(String u_hobby) {
		this.u_hobby = u_hobby;
	}
	public String getU_edu() {
		return u_edu;
	}
	public void setU_edu(String u_edu) {
		this.u_edu = u_edu;
	}
	public String getU_salarycard() {
		return u_salarycard;
	}
	public void setU_salarycard(String u_salarycard) {
		this.u_salarycard = u_salarycard;
	}
	public String getU_nation() {
		return u_nation;
	}
	public void setU_nation(String u_nation) {
		this.u_nation = u_nation;
	}
	public String getU_marry() {
		return u_marry;
	}
	public void setU_marry(String u_marry) {
		this.u_marry = u_marry;
	}
	public String getU_remark() {
		return u_remark;
	}
	public void setU_remark(String u_remark) {
		this.u_remark = u_remark;
	}
	public Timestamp getU_updatetime() {
		return u_updatetime;
	}
	public void setU_updatetime(Timestamp u_updatetime) {
		this.u_updatetime = u_updatetime;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "BeanWork [u_id=" + u_id + ", u_name=" + u_name + ", u_pwd=" + u_pwd + ", u_departmentid="
				+ u_departmentid + ", u_roleid=" + u_roleid + ", u_sex=" + u_sex + ", u_phone=" + u_phone
				+ ", u_address=" + u_address + ", u_age=" + u_age + ", u_telphone=" + u_telphone + ", u_idcard="
				+ u_idcard + ", u_mail=" + u_mail + ", u_qq=" + u_qq + ", u_hobby=" + u_hobby + ", u_edu=" + u_edu
				+ ", u_salarycard=" + u_salarycard + ", u_nation=" + u_nation + ", u_marry=" + u_marry + ", u_remark="
				+ u_remark + ", u_updatetime=" + u_updatetime + ", departmentName=" + departmentName + ", roleName="
				+ roleName + "]";
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		
		System.out.println("钝化-----!");
	}
	
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化-----!");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
