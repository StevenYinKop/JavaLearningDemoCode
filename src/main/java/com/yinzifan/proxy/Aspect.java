package com.yinzifan.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface Aspect {
    static <T> T getProxy(Class<T> clz, String... aspects) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 通过字符串创建实例
        List<Aspect> aspectList = Arrays
                .stream(aspects)
                .map(name -> {
                    try {
                        Class<?> clazz = Class.forName(name);
                        return (Aspect) clazz.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException | ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        T inst = clz.getConstructor().newInstance();
        return (T) Proxy.newProxyInstance(
                clz.getClassLoader(),
                clz.getInterfaces(),
                (proxy, method, args) -> {
                    aspectList.forEach(Aspect::before);
                    Object result = method.invoke(inst, args);
                    aspectList.forEach(Aspect::after);
                    return result;
                }
        );
    }

    void before();

    void after();
}
