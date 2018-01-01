package com.yinzifan.java8Demo.lambda;
/**
* @author Cin
* @time 2018/01/01 20:31:37
*/

import org.junit.Test;

public class LambdaDemo03 {

	public void wrapWork(IMyWork work) {
		System.out.println("do some thing...");
		work.work();
	}
	@Test
	public void test1() throws Exception {
		this.wrapWork(()->System.out.println("do test1"));
	}
	@Test
	public void test2() throws Exception {
		IMyWork oWork = ()->System.out.println("do test2");
		this.wrapWork(oWork);
		/**
		 * 因为lambda表达式是java编译器去推导出来的,如果我们向下面这样写的话,它只能根据上下文环境将oWork2推导成Runnable接口
		 */
		// Runnable oWork2 = ()->System.out.println("do test2");
		
	}
}
