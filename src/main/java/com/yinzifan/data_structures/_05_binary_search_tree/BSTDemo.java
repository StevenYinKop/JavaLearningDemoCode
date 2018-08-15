package com.yinzifan.data_structures._05_binary_search_tree;

import java.util.Random;
import java.util.function.Consumer;

public class BSTDemo {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int ran = random.nextInt(100);
			System.out.println("i = " + i +", ran: " + ran);
			bst.add(ran);
		}
		System.out.println(bst.toString());
		MyConsumer consumer = new MyConsumer();
//		System.out.println("前序遍历: ");
//		bst.preOrder(consumer);
//		System.out.println("中序遍历: ");
//		bst.inOrder(consumer);
//		System.out.println("后序遍历: ");
//		bst.postOrder(consumer);
		
		System.out.println("广度优先遍历: ");
		bst.levelOrder(consumer);
		
	}
}

class MyConsumer implements Consumer<Integer> {
	@Override
	public void accept(Integer i) {
		System.out.println(i);
	}
	
}