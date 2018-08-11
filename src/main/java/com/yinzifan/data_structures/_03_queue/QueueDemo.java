package com.yinzifan.data_structures._03_queue;

public class QueueDemo {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Queue<Integer> arr = new LoopQueue<>(5);
		for (int i = 0; i < 200000; i++) {
			arr.enqueue(i);
		}
		for (int i = 0; i < 200000; i++) {
			arr.dequeue();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("spend: " + ((endTime - startTime)/1000.0) + "s");
		
		
		
		long startTime1 = System.currentTimeMillis();
		Queue<Integer> arr1 = new ArrayQueue<>(5);
		for (int i = 0; i < 200000; i++) {
			arr1.enqueue(i);
		}
		for (int i = 0; i < 200000; i++) {
			arr1.dequeue();
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("spend: " + ((endTime1 - startTime1)/1000.0) + "s");
	}
}
