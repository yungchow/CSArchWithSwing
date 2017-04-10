package com.yc.domain;

import java.io.Serializable;

public class Emp implements Serializable{
	private Integer id;
	private String name;
	private String gender;
	private String skill;
	private Integer age;
	private String job;
	
	public Emp(){}
	
	public Emp(Integer id, String name, String gender, String skill,
			Integer age, String job) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.skill = skill;
		this.age = age;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", skill=" + skill + ", age=" + age + ", job=" + job + "]";
	}
	
}
