package com.yinzifan.architects.$01_thread;

public class ChangeLock {

	private String lock = "lock";
	private void method() {
		synchronized (lock) {
			try {
				System.out.println("当前线程: " + Thread.currentThread().getName() + "开始");
				lock = "change lock"; // 注释这句话观察效果
				Thread.sleep(2000);
				System.out.println("当前线程: " + Thread.currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final ChangeLock changeLock = new ChangeLock();
		Thread t1 = new Thread(()-> changeLock.method(), "t1");
		Thread t2 = new Thread(()-> changeLock.method(), "t2");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
