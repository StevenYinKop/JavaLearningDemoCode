package com.yinzifan.week3._2;

public class Car extends Auto{
	private String airCondition;
	public Car(int wheels, String color, int weight, int speed) {
		super(wheels, color, weight, speed);
	}

	@Override
	public void speedUp() {
		setSpeed(getSpeed() + 2);
	}

	@Override
	public void speedDown() {
		setSpeed(getSpeed() - 2);
	}

	public String getAirCondition() {
		return airCondition;
	}

	public void setAirCondition(String airCondition) {
		this.airCondition = airCondition;
	}
	
}
