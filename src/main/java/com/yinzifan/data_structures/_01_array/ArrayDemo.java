package com.yinzifan.data_structures._01_array;

public class ArrayDemo {
	public static void main(String[] args) {
		Array<Integer> arr = new Array<>();
		for (int i = 0; i < 10; i++) {
			arr.addLast((int) (Math.random() * 100));
		}
		arr.addLast((int) (Math.random() * 100));
		System.out.println(arr.toString());
		arr.remove(0);
		System.out.println(arr.toString());
	}
}
