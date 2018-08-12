package com.yinzifan.data_structures._03_queue;

public class QueueDemo {
	private static final int CNT = 200000;
	public static void main(String[] args) {
		System.out.println("spend: " + test(new LoopQueue<>(), CNT) + "s");
		System.out.println("spend: " + test(new ArrayQueue<>(), CNT) + "s");
	}
	private static double test(Queue<Integer> queue, int cnt) {
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < cnt; i++) {
			queue.dequeue();
		}
		long endTime1 = System.currentTimeMillis();
		return (endTime1 - startTime1)/1000.0;
	}
	
	
}
