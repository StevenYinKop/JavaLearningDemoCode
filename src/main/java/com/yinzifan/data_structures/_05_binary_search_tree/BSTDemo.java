package com.yinzifan.data_structures._05_binary_search_tree;

import java.util.Random;
import java.util.function.Consumer;

public class BSTDemo {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int ran = random.nextInt(100);
			System.out.println("i = " + i + ", ran: " + ran);
			bst.add(ran);
		} 
		System.out.println(bst.toString());
		Consumer<Integer> consumer = System.out::println;
		System.out.println("前序遍历: ");
		bst.preOrder(consumer);
		System.out.println("中序遍历: ");
		bst.inOrder(consumer);
		System.out.println("后序遍历: ");
		bst.postOrder(consumer);

		System.out.println("广度优先遍历: ");
		bst.levelOrder(consumer);

		System.out.println("获取树中最大值和最小值: ");
		bst.clear();
		for (int i = 0; i < 10; i++) {
			int ran = random.nextInt(10000);
			System.out.println("i = " + i + ", ran: " + ran);
			bst.add(ran);
		}
		// bst.add(3739);
		// bst.add(230);
		// bst.add(6903);
		// bst.add(6119);
		// bst.add(5661);
		// bst.add(6997);
		// bst.add(972);
		// bst.add(8729);
		// bst.add(9888);
		// bst.add(3815);
		// i = 0, ran: 3739
		// i = 1, ran: 230
		// i = 2, ran: 6903
		// i = 3, ran: 6119
		// i = 4, ran: 5661
		// i = 5, ran: 6997
		// i = 6, ran: 972
		// i = 7, ran: 8729
		// i = 8, ran: 9888
		// i = 9, ran: 3815
		// bst.remove(3739);
		System.out.println(bst.toString());
	}
}

class MyConsumer implements Consumer<Integer> {
	@Override
	public void accept(Integer i) {
		System.out.println(i);
	}

}