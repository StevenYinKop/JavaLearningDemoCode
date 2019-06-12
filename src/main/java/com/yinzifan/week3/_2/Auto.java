package com.yinzifan.week3._2;

public class Auto {
	private int wheels;
	private String color;
	private int weight;
	private int speed;
	public Auto(int wheels, String color, int weight, int speed) {
		super();
		this.wheels = wheels;
		this.color = color;
		this.weight = weight;
		this.speed = speed;
	}
	public void speedUp() {
		this.speed ++;
	}
	public void speedDown () {		
		this.speed --;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
