package com.yinzifan.design_pattern.principle.single_responsibility;

public class SingleResponsibility1 {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("motor");
		vehicle.run("car");
		vehicle.run("plane");
	}
}

class Vehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "is running on the road");
	}
}