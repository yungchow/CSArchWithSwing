package com.yc.domain;

public class User {

	private Integer no;
	private String name;
	private String gender;
	private String pwd;
	
	public User(){}
	
	public User(Integer no, String name, String gender, String pwd) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.pwd = pwd;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", gender=" + gender
				+ ", pwd=" + pwd + "]";
	}
	

}
