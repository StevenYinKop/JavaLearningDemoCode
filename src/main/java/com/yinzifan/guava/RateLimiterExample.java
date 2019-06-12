package com.yinzifan.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterExample {

	private static final RateLimiter rateLimiter = RateLimiter.create(2);
	
	private final static Semaphore semaphore = new Semaphore(4);
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i ++) {
			service.submit(()-> {
				System.out.println("Thread.start()");
//				RateLimiterExample.testLimiter();
				RateLimiterExample.testSemaphore();
			});
		}
	}
	private static void testLimiter() {
		System.out.println(Thread.currentThread() + "waiting: " + rateLimiter.acquire());
	}
	
	private static void testSemaphore() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread() + "is coming and do work.");
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println(Thread.currentThread() + "is over.");
		}
	}
}
