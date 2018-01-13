package com.yinzifan.juc;
/**
* @author Cin
* @time 2018/01/07 19:53:16
*/
public class VolatileDemo {
	/**
	 * volatile: 当多线程操作共享数据时, 可以保证内存中的数据可见
	 * 注意: 	1. volatile不具备互斥性
	 * 			2. 不能保证变量的原子性
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		// 內存可见性问题: 当多个线程操作共享数据时, 彼此不可见
		while(true) {
			if (td.isFlag()) {
				System.out.println("-----------------------------");
				break;
			}
		}
	}
}

class ThreadDemo implements Runnable{
	private volatile boolean flag = false;
//	private boolean flag = false;
	@Override
	public void run() {
		try {
			Thread.sleep(200);
			flag = true;
			if (flag) {
				System.out.println("flag is true");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}