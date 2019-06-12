package week6._2;

public class Main {
	public static int count = 10;
	private static Object obj = new Object();
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			while (count > 0) {
				synchronized (obj) {
					if (count % 2 == 1) {
						count--;
						System.out.println("窗口1售票, 还剩" + count + "张");
						obj.notifyAll();
					} else {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			while (count > 0) {
				synchronized (obj) {
					if (count % 2 == 0) {
						count--;
						System.out.println("窗口2售票, 还剩" + count + "张");
						obj.notifyAll();
					} else {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}); 
		t1.start();
		t2.start();
	}
}
