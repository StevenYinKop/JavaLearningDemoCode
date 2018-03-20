package com.yinzifan.architects.$01_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class _08_AtomicUse {

	private static AtomicInteger count = new AtomicInteger();

	public synchronized int multiAdd() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);
		return count.get();
	}
	
	public static void main(String[] args) {
		final _08_AtomicUse au = new _08_AtomicUse();
		List<Thread> list = new ArrayList<>();
		for(int i = 0; i<100; i++) {
			list.add(new Thread(()->System.out.println(au.multiAdd())));
		}
		for (Thread thread : list) {
			thread.start();
		}
	}
}
