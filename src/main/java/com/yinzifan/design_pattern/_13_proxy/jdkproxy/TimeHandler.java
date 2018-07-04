package com.yinzifan.design_pattern._13_proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	/**
	 * proxy: 被代理对象
	 * method: 被代理对象的方法
	 * args: 方法的参数
	 * 
	 * 返回值: Object: 方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		method.invoke(target);
		return null;
	}

}
