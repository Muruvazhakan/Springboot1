package com.test;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	
	private Integer id;
	
	@Size(min=2, message="Minum must be 2char")
	private String userName;
	@Past(message="No past")
	private LocalDate dob;
	private String desc;
	
	
	public User(Integer id, String userName, LocalDate dob) {
		super();
		this.id = id;
		this.userName = userName;
		this.dob = dob;
	}
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", dob=" + dob + "]";
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
}
