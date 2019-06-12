package com.yinzifan.week3._1;

public abstract class Animal {
	private String name;
	public abstract String enjoy();
	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
