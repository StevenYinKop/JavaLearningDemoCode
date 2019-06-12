package com.yinzifan.guava;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor.Guard;
import com.google.common.util.concurrent.RateLimiter;

public class Bucket {

	private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();
	
	private final static int BUCKET_LIMIT = 1000;
	
	private final RateLimiter limiter = RateLimiter.create(10);
	
	private final Monitor OFFER = new Monitor();
	private final Monitor POLL = new Monitor();
	
	public void submit(Integer data) {
		if(OFFER.enterIf(new Guard(OFFER) {
			@Override
			public boolean isSatisfied() {
				return container.size() < BUCKET_LIMIT;
			}
		})) {
			try {
				container.offer(data);
				System.out.println(Thread.currentThread() + "submit data: " + data + ", current size: " + container.size());
			} finally {
				OFFER.leave();
			}
		} else {
			throw new IllegalStateException("The bucket is full.");
		}
	}
	public void takeThenConsume(Consumer<Integer> consumer) {
		if (POLL.enterIf(new Guard(POLL) {
			@Override
			public boolean isSatisfied() {
				return !container.isEmpty();
			}
		})) {
			System.out.println(Thread.currentThread() + "" + limiter.acquire());
			consumer.accept(container.poll());
			POLL.leave();
		}
	}
}
