package week3._2;
public class Test {
	public static void main(String[] args) {
		Car car = new Car(4, "黑色", 20, 0);
		car.setAirCondition("制冷!");
		System.out.println("轮子: " + car.getWheels() + "个, 颜色: " +car.getColor() + ", 重量: " +car.getWeight() + "kg, 速度: " +car.getSpeed() + ", 空调: " +car.getAirCondition());
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedUp();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
		car.speedDown();
		System.out.println("当前车速为: " + car.getSpeed() + "m/h");
	}
}
