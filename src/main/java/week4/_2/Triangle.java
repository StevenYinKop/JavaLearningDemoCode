package week4._2;

import java.util.Scanner;

/**
 * 写一个方法void isTriangle(int a,int b,int c)， 判断三个参数是否能构成一个三角形， 
 * 如果不能则抛出异常IllegalArgumentException，显示异常信息 “a,b,c不能构成三角形”，
 * 如果可以构成则显示三角形三个边长，在主方法中得到命令行输入的三个整数，  调用此方法，并捕获异常。
 * 
 * @author Cin
 *
 */
public class Triangle {
	public static void isTriangle(int a, int b, int c){
		if (a + b <= c || b + c <= a || c + a <= b) {
			throw new IllegalArgumentException();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		try {
			isTriangle(a, b, c);
		} catch (Exception e) {
			System.out.println(a + "," + b + "," + c + ",这三个数字不能构成三角形!");
			e.printStackTrace();
		}
	}
}
