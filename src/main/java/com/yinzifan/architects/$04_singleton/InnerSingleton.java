package com.yinzifan.architects.$04_singleton;

public class InnerSingleton {

	private static class Singleton {
		private static Singleton single = new Singleton();
	}
	
	public static Singleton getInstance() {
		return Singleton.single;
	}
	
}
