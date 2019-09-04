package com.yinzifan.design_pattern.principle.single_responsibility;

public class SingleResponsibility2 {
	public static void main(String[] args) {
		RoadVehicle roadVehicle = new RoadVehicle();
		roadVehicle.run("motor");
		roadVehicle.run("car");
		WaterVehicle waterVehicle = new WaterVehicle();
		waterVehicle.run("boat");
		AirVehicle airVehicle = new AirVehicle();
		airVehicle.run("plane");
	}
}

class RoadVehicle {
	public void run(String roadVehicle) {
		System.out.println(roadVehicle + " is running on the road");
	}
}
class AirVehicle {
	public void run(String airVehicle) {
		System.out.println(airVehicle + " is running on the air");
	}
}
class WaterVehicle {
	public void run(String waterVehicle) {
		System.out.println(waterVehicle + " is running in the water");
	}
}
