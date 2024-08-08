package com.test;

public class Name {
	private String firstName;
	private String SecName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecName() {
		return SecName;
	}
	public Name(String firstName, String secName) {
		super();
		this.firstName = firstName;
		SecName = secName;
	}
	public void setSecName(String secName) {
		SecName = secName;
	}
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}
}
