package com.yinzifan.architects.$03_threadlocal;

public class ConnThreadLocal {

	public static ThreadLocal<String> th = new ThreadLocal<>();
	
	public void setTh(String value) {
		th.set(value);
	}
	public void getTh() {
		System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
	}
	public static void main(String[] args) {
		final ConnThreadLocal ct = new ConnThreadLocal();
		Thread t1 = new Thread(()->{
			ct.setTh("zhangsan");
			ct.getTh();
		},"t1");
		Thread t2 = new Thread(()-> {
			try {
				Thread.sleep(1000);
				ct.getTh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
	
}
