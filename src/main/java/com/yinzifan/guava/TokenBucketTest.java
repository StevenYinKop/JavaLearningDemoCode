package com.yinzifan.guava;

import java.util.stream.IntStream;

public class TokenBucketTest {

	public static void main(String[] args) {
		final TokenBucket tokenBucket = new TokenBucket();
		IntStream.range(0, 315).forEach(x->{
			new Thread(()->{
				tokenBucket.consumer();
			}).start();
		});
	}
}
