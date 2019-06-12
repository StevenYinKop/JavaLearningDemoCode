package com.yinzifan.guava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BucketTest {
	public static void main(String[] args) {
		final Bucket bucket = new Bucket();
		final AtomicInteger DATA_CREATOR = new AtomicInteger(0);
		IntStream.range(0, 5).forEach(x -> {
			new Thread(() -> {
				for(;;) {
					try {
						int v = DATA_CREATOR.getAndIncrement();
						bucket.submit(v);
						TimeUnit.MILLISECONDS.sleep(100L);
					} catch (Exception e) {
						if (e instanceof IllegalStateException) {
							System.out.println(e.getMessage());
						}
					}
				}
			}) .start();
		});
		IntStream.range(0, 5).forEach(x -> {
			new Thread(() -> {
				for(;;) {
					bucket.takeThenConsume(v -> {
						System.out.println(Thread.currentThread() + " W " + v);
					});
				}
			}) .start();
		});
	}
}
