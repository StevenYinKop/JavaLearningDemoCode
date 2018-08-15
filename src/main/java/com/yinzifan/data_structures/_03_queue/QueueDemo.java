package com.yinzifan.data_structures._03_queue;

import com.yinzifan.data_structures._03_queue.impl.ArrayQueue;
import com.yinzifan.data_structures._03_queue.impl.LoopQueue;
import com.yinzifan.data_structures._04_linkedlist.LinkedListQueue;

public class QueueDemo {
	private static final int CNT = 200000;
	public static void main(String[] args) {
		System.out.println("ArrayQueue: spend: " + test(new ArrayQueue<>(), CNT) + "s");
		System.out.println("LoopQueue: spend: " + test(new LoopQueue<>(), CNT) + "s");
		System.out.println("LinkedListQueue: spend: " + test(new LinkedListQueue<>(), CNT) + "s");
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
