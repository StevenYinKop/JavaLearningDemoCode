package com.yinzifan.architects.$01_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author alienware
 * java.util.concurrent.CountDownLatch 实现实时通知
 */
public class _09_03_ListAdd_CountdownLatch {
	private volatile static List list = new ArrayList();
	final static CountDownLatch countDownLatch = new CountDownLatch(1);

	public void add() {
		list.add("bjsxt");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {

		final _09_03_ListAdd_CountdownLatch list2 = new _09_03_ListAdd_CountdownLatch();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t1启动..");
					for (int i = 0; i < 10; i++) {
						list2.add();
						System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
						Thread.sleep(500);
						if (list2.size() == 5) {
							System.out.println("已经发出通知..");
							countDownLatch.countDown();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t2启动..");
				if (list2.size() != 5) {
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止..");
				throw new RuntimeException();
			}
		}, "t2");
		
		t2.start();
		t1.start();

	}

}
