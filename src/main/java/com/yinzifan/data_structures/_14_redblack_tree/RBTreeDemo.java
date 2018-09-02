package com.yinzifan.data_structures._14_redblack_tree;

import java.util.ArrayList;

import com.yinzifan.data_structures.utils.FileOperation;

public class RBTreeDemo {

	public static void main(String[] args) {
//		RBTree<Integer, Integer> tree = new RBTree<>();
//
//		int[] arr = new int[] { 13, 28, 77, 78, 3, 73, 24, 28, 13, 3, 89, 100, 1, 2, 28, 1 };
//		for (int i = 0; i < arr.length; i++) {
//			int r = arr[i];
//			System.out.println("Random: " + r);
//			tree.add(r, tree.contains(r) ? tree.get(r) + 1 : 1);
//		}
//		System.out.println("Tree Size: " + tree.getSize());
//		System.out.println("Frequency of 13: " + tree.get(13));
//		System.out.println("Frequency of 28: " + tree.get(28));

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("src/main/java/com/yinzifan/data_structures/_13_avl_tree/pride-and-prejudice.txt",
				words)) {
			System.out.println("Total words: " + words.size());

			RBTree<String, Integer> map = new RBTree<>();
			for (String word : words) {
				if (map.contains(word))
					map.add(word, map.get(word) + 1);
				else
					map.add(word, 1);
			}

			System.out.println("Total different words: " + map.getSize());
			System.out.println("Frequency of PRIDE: " + map.get("pride"));
			System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

		}

		System.out.println();
	}
}
