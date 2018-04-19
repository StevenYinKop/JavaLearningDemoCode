package com.yinzifan.architects.$01_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class _07_VolatileNoAtomic extends Thread{

//	private static volatile int count;
	private static AtomicInteger count = new AtomicInteger(0);
	private static void addCount() {
		for(int i = 0; i<1000; i++) {
//			count++;
			count.incrementAndGet();
		}
		System.out.println(count);
	}

	@Override
	public void run() {
		addCount();
	}
	
	public static void main(String[] args) {
		_07_VolatileNoAtomic[] arr = new _07_VolatileNoAtomic[10];
		for(int i = 0; i<10; i++) {
			arr[i] = new _07_VolatileNoAtomic();
		}		
		for(int i = 0; i<10; i++) {
			arr[i].start();
		}		
	}
}

