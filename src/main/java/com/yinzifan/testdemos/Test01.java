package com.yinzifan.testdemos;

import java.lang.reflect.Field;

public class Test01 {

	public static void main(String[] args) {
		Integer a = new Integer(1), b = 1;
		System.out.println(a == b);
		
		
//		System.out.println("before: a= "+a + ", b = " + b);
//		swap(a, b);
//		System.out.println("after: a= "+a + ", b = " + b);
	}

	private static void swap(Integer a, Integer b) {
		try {
			Field field = Integer.class.getDeclaredField("value");
			int temp = new Integer(a);
			field.setAccessible(true);
			field.setInt(a, b);
			field.setInt(b, temp);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
