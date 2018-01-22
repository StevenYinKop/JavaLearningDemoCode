package com.yinzifan.entity;
/**
* @author Cin
* @time 2018/01/18 23:01:32
*/
public class Person {
	private String name;
	private Integer age;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person() {
		super();
	}
	public Person(Integer age) {
		super();
		this.age = age;
	}
	public Person(String name, Integer age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", address=" + address + "]";
	} 
	
}
