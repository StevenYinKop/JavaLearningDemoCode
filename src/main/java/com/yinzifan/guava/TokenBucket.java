package com.yinzifan.guava;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

public class TokenBucket {
	
	private AtomicInteger number = new AtomicInteger(0);
	
	private final static int LIMIT = 100;
	
	private RateLimiter rateLimiter = RateLimiter.create(10);
	
	private final int limit;
	
	public TokenBucket() {
		this(LIMIT);
	}
	
	public TokenBucket(int limit) {
		this.limit = limit;
	}
	
	public int consumer() {
		Stopwatch started = Stopwatch.createStarted();
		boolean success = rateLimiter.tryAcquire(10, TimeUnit.SECONDS);
		if (success) {
			if (this.number.get() >= this.limit) {
				throw new IllegalStateException("no token remained");
			}
			int no = number.getAndIncrement();
			this.handleOrder();
			System.out.println(Thread.currentThread() + "user get token: " + no + ", ELT: " + started.stop());
			return no;
		} else {
			throw new RuntimeException("no token generated! ELT: " + started.stop());
		}
	}
	private void handleOrder() {
		try {
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
