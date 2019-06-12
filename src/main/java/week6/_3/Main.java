package week6._3;

/**
 * 编写两个线程,一个线程打印1-52的整数，
 * 另一个线程打印字母A-Z。打印顺序为12A34B56C….5152Z。
 * 即按照整数和字母的顺序从小到大打印，并且每打印两个整数后，
 * 打印一个字母，交替循环打印，直到打印到整数52和字母Z结束
 *
 */
public class Main {
	private static char letter = 'A';
	private static int num = 1;
	public static void main(String[] args) {
		Object obj = new Object();
		Thread t1 = new Thread(() -> {
			while(num <= 52) {
				synchronized (obj) {
					obj.notifyAll();
					System.out.print(num++);
					System.out.print(num++);
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			while(letter <= 'Z') {
				synchronized (obj) {
					obj.notifyAll();
					System.out.print(letter++ + "");
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
