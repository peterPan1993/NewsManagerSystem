package com.bdqn.entity;

import java.io.Serializable;

public abstract class AbstractUser implements Serializable {

	protected Integer id;
	protected String userName;
	protected String password;
	protected Character gender;
	protected Long phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public AbstractUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbstractUser(Integer id, String userName, String password, Character gender,
                        Long phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
	}
	
}
