package com.test.Person;

public class Personv1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Personv1(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Personv1 [name=" + name + "]";
	}
	
}
