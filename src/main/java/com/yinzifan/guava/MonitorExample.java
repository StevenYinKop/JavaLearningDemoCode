package com.yinzifan.guava;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor.Guard;

public class MonitorExample {

	
	public static void main(String[] args) {
//		final Synchronized demo = new Synchronized();
//		final LockCondition demo = new LockCondition();
		final MonitorGuard demo = new MonitorGuard();
		final AtomicInteger COUNTER = new AtomicInteger(0);
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				for (;;) {
					try {
						int data = COUNTER.incrementAndGet();
						System.out.println(Thread.currentThread() + "offer " + data);
						demo.offer(data);
						TimeUnit.MILLISECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				for (;;) {
					try {
						int data = demo.take();
						System.out.println(Thread.currentThread() + "take " + data);
						TimeUnit.MILLISECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	static class LockCondition {
		private final ReentrantLock lock = new ReentrantLock();
		private final Condition FULL_CONDITION = lock.newCondition();
		private final Condition EMPTY_CONDITION = lock.newCondition();
		private final LinkedList<Integer> queue = new LinkedList<>();
		private final int MAX = 10;
		
		public void offer(int value) {
			doLock((t) -> {
				while(queue.size() >= MAX) {
					try {
						FULL_CONDITION.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.addLast(t);
				EMPTY_CONDITION.signalAll();
				return null;
			}, value);
		}
		
		public int take() {
			return doLock(t -> {
				while(queue.isEmpty()) {
					try {
						EMPTY_CONDITION.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Integer value = queue.removeFirst();
				FULL_CONDITION.signalAll();
				return value;
			}, null);
		}
		
		private <T, R> R doLock(Function<T, R> fun, T t) {
			try {
				lock.lock();
				return fun.apply(t);
			} finally {
				lock.unlock();
			}
		}
		
	}
	
	static class Synchronized {
		private final LinkedList<Integer> queue = new LinkedList<>();
		private final int MAX = 10;
		public void offer(int value) {
			synchronized(queue) {
				while(queue.size() >= MAX) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.addLast(value);
				queue.notifyAll();
			}
		}
		public int take() {
			synchronized(queue) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Integer value = queue.removeFirst();
				queue.notifyAll();
				return value;
			}
		}
	}
	
	static class MonitorGuard {
		private final LinkedList<Integer> queue = new LinkedList<>();
		private final int MAX = 10;
		private final Monitor monitor = new Monitor();
		
		public void offer(Integer value) {
			try {
				monitor.enterWhen(new CanOfferGuard(monitor, queue, MAX));
				queue.addLast(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				monitor.leave();
			}
		}
		
		public int take() {
			try {
				monitor.enterWhen(new CanTakeGuard(monitor, queue));
				return queue.removeFirst();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			} finally {
				monitor.leave();
			}
		}
		
		
		class CanOfferGuard extends Guard {
			private LinkedList<Integer> queue;
			private int MAX;
			protected CanOfferGuard(Monitor monitor, LinkedList<Integer> queue, int MAX) {
				super(monitor);
				this.queue = queue;
				this.MAX = MAX;
			}
			@Override
			public boolean isSatisfied() {
				return this.queue.size() < this.MAX;
			}
		}
		class CanTakeGuard extends Guard {
			private LinkedList<Integer> queue;
			protected CanTakeGuard(Monitor monitor, LinkedList<Integer> queue) {
				super(monitor);
				this.queue = queue;
			}
			@Override
			public boolean isSatisfied() {
				return !this.queue.isEmpty();
			}
		}
		
	}
}
