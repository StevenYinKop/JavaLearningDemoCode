package com.yinzifan.testdemos;

public class Test01 {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operator(a,b);
		System.out.println(a+","+b);
	}

	private static void operator(StringBuffer a, StringBuffer b) {
		a.append(b);
		b=a;
	}
}
