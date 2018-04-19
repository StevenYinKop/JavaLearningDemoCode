package com.yinzifan.architects.$02_queue;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟一个有容量限制的容器
 * 
 * @author Cin
 *
 */
public class MyQueue {

	// 1. 需要一个集合用来装元素
	private final LinkedList<Object> list = new LinkedList<>();
	// 2. 需要一个计数器
	private AtomicInteger count = new AtomicInteger();
	// 3. 需要指定上限和下限
	private int minSize = 0;
	private int maxSize;

	// 4. 构造
	public MyQueue(int size) {
		this.maxSize = size;
	}

	// 5. 初始化一个对象 用于加锁
	private final Object lock = new Object();

	// put(Object) : 把Object加到BlockingQueue里面, 如果BlockQueue没有空间, 则调用此方法的线程被阻断,
	// 直到BlockingQueue
	public void put(Object obj) {
		synchronized (lock) {
			while (count.get() == this.maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.addLast(obj);
			count.incrementAndGet();
			System.out.println("新加入的元素: " + obj);
			lock.notify();
		}
	}

	// take(): 取走BlockingQueue里面排在首位的对象, 若BlockingQueue为空,
	// 则阻断进入等待状态直到BlockingQueue有新的数据被加入
	public Object take() {
		Object ret = null;
		synchronized (lock) {
			while (count.get() == this.minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			ret = list.removeFirst();
			count.decrementAndGet();
			lock.notify();
		}
		return ret;
	}

	public int getSize() {
		return this.count.get();
	}

	public static void main(String[] args) {
		MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		System.out.println("当前容器的长度为: " + mq.getSize());
		new Thread(() -> {
			mq.put("f");
			mq.put("g");
			mq.put("h");
		}, "t1").start();
		
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			Object o1 = mq.take();
			System.out.println("移除的元素为: " + o1);
			Object o2 = mq.take();
			System.out.println("移除的元素为: " + o2);
		}, "t2").start();
		
		
		
		
		
	}
}
