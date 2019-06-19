package com.yinzifan.testdemos;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class YmlTest {
	public static void main(String[] args) {
		LinkedHashMap<String, String> map = Maps.newLinkedHashMap();
		map.put("spring.profiles.active", "dev");
		map.put("mybatis.mapper-locations", "mappers/*.xml");
		map.put("mybatis.type-aliases-package", "xyz.cincommon.model");
		map.put("spring.jackson.serialization.write-dates-as-timestamps", "true");
		map.put("spring.thymeleaf.prefix", "classpath:/templates/");
		map.put("spring.thymeleaf.check-template-location", "true");
		map.put("spring.thymeleaf.suffix", ".html");
		map.put("spring.thymeleaf.encoding", "UTF-8");
		map.put("spring.thymeleaf.content-type", "text/html");
		map.put("spring.thymeleaf.mode", "HTML5");
		map.put("spring.thymeleaf.cache", "false");
		map.put("server.port", "8081");
		map.put("logging.level.xyz.cincommon.mapper", "DEBUG");
		map.put("spring.datasource.type", "com.alibaba.druid.pool.DruidDataSource");
		map.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");
		map.put("spring.datasource.username", "ENC(077GOkbA/NaU3Ahs47wdVw==)");
		map.put("spring.datasource.password", "ENC(Lkbx0F0SZ9yweeCZGZbTq86CuFmiKBtkr2N2pIMbkLY=)");
		map.put("spring.datasource.url", "ENC(9DqWB84slc+eh742SPz3lc/adeuXeX2pY9GmFzhM1+PGQOTdYBNBvsaYxvrTvS1ctgdm6VLOJFuVkHeQIt2aV75BBZvGVnqzLIG7snNSvB4HQyMiObfSU72ox6ji5sK3)");
		
		LinkedHashMap<String, Object> result = generateToYML(map);
		System.out.println(result);
	}

	private static LinkedHashMap<String, Object> generateToYML(LinkedHashMap<String, String> map) {
		LinkedHashMap<String, Object> result = Maps.newLinkedHashMap();
		for (Entry<String, String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
			String[] kArr = k.split("\\.");
			if (kArr.length == 1) {
				result.put(k, v);
			} else {
				putValueToLinkedHashMap(kArr, v, result);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static void putValueToLinkedHashMap(String[] kArr, String val, LinkedHashMap<String, Object> result) {
		if (kArr.length == 1) {
			result.put(kArr[0], val);
		} else {
			LinkedHashMap<String, Object> cacheMap = null;
			if (result.get(kArr[0]) == null) {
				cacheMap = Maps.newLinkedHashMap();
			} else {
				cacheMap = (LinkedHashMap<String, Object>) result.get(kArr[0]);
			}
			result.put(kArr[0], cacheMap);
			putValueToLinkedHashMap(Arrays.copyOfRange(kArr, 1, kArr.length), val, cacheMap);
		}
	}
}
