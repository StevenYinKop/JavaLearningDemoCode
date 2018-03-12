package com.yinzifan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.yinzifan.entity.Node;

public class RecursionDemo02 {

	
	public static void recur(List<Node> list, List<Node> result) {
		
	}
	
	public static void main(String [] args) {
		List<Node> list = Arrays.asList(new Node[] {
				//Node(String id,String pid,String name,List<Node> nodes)
				new Node("1", "-", "name1", null),
				new Node("2", "1", "name2", null),
				new Node("3", "-", "name3", null),
				new Node("4", "2", "name4", null),
				new Node("5", "6", "name5", null),
				new Node("6", "7", "name6", null),
				new Node("7", "1", "name7", null),
				new Node("8", "2", "name8", null),
				new Node("9", "3", "name9", null),
				new Node("10", "5", "name10", null),
				new Node("11", "7", "name11", null),
				new Node("12", "8", "name12", null),
				new Node("13", "2", "name13", null),
				new Node("14", "5", "name14", null),
				new Node("15", "1", "name15", null),
				new Node("16", "10", "name16", null),
				new Node("17", "15", "name17", null),
				new Node("18", "16", "name18", null),
				new Node("19", "11", "name19", null),
				new Node("20", "7", "name20", null),
				new Node("21", "8", "name21", null),
				new Node("22", "8", "name22", null),
				new Node("23", "8", "name23", null),
				new Node("24", "21", "name24", null),
				new Node("25", "23", "name25", null),
		});
		List<Node> result = new ArrayList<>();
		recur(list, result);
		System.out.println(result);
	}
}
