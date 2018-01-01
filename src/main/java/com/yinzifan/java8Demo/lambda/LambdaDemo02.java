package com.yinzifan.java8Demo.lambda;
/**
* @author Cin
* @time 2018/01/01 20:03:58
*/

import java.util.Arrays;

import org.junit.Test;

public class LambdaDemo02 {
	@Test
	public void test1() throws Exception {
		new Thread(()->System.out.println("LambdaDemo02.test1()")).start();
	}
	@Test
	public void test2() throws Exception {
		String[] str = new String[] {"zhangsan","lisi", "wangwu"};
		Arrays.sort(str, (s1,s2)->Integer.compare(s1.length(), s2.length()));
		System.out.println(Arrays.toString(str));
	}
	public void repeatPrint(String content, int times) {
		Runnable runnable = () -> {
			for (int i = 0; i < times; i++) {
				System.out.println(content);
			}
		};
		new Thread(runnable).start();
	}
	@Test
	public void test3() throws Exception {
		repeatPrint("content" , 5);
	}
}
