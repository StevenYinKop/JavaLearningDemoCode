package com.yinzifan.architects.$01_thread;

public class _06_RunThread extends Thread{
	private volatile boolean isRunning = true;
//	private  boolean isRunning = true;
	private void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入run方法");
		while(isRunning) {
			
		}
		System.out.println("run方法结束");
	}
	
	public static void main(String[] args) throws InterruptedException {
		_06_RunThread rt = new _06_RunThread();
		rt.start();
		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("setRunning(false)");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
	
}
