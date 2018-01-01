package com.yinzifan.java8Demo.lambda;

import java.util.List;

/**
* @author Cin
* @time 2018/01/01 21:24:06
*/
@FunctionalInterface
public interface IMyAsList<T extends List<?>> {
	T create();
}
