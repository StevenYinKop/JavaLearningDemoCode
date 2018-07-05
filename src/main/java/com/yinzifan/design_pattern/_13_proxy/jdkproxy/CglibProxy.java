package com.yinzifan.design_pattern._13_proxy.jdkproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clz) {
		enhancer.setSuperclass(clz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/**
	 * 拦截所有目标类方法的调用
	 * obj: 目标类的实例
	 * m: 目标方法的反射对象
	 * args: 方法的参数
	 * proxy: 代理类的实例
	 */
	@Override
	public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
		return null;
	}

}
