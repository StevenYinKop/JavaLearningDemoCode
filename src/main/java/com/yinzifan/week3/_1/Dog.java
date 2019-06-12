package com.yinzifan.week3._1;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	@Override
	public String enjoy() {
		return "我嗨皮的一比, 汪汪汪";
	}
}
