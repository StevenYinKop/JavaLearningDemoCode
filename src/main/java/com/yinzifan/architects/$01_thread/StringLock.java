package com.yinzifan.architects.$01_thread;

public class StringLock {

	public void method() {
		synchronized ("字符串") {
			try {
				while (true) {
					System.out.println("当前线程: " + Thread.currentThread().getName() + "开始");
					Thread.sleep(1000);
					System.out.println("当前线程: " + Thread.currentThread().getName() + "结束");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final StringLock stringLock = new StringLock();
		Thread t1 = new Thread(() -> stringLock.method(), "t1");
		Thread t2 = new Thread(() -> stringLock.method(), "t2");
		// 这时的运行结果,仅仅是t1不停地开始和结束。
		t1.start();
		t2.start();
	}
}
