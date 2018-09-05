package com.yinzifan.data_structures._07_map;

import java.util.ArrayList;

import com.yinzifan.data_structures._07_map.impl.AVLMap;
import com.yinzifan.data_structures._07_map.impl.BSTMap;
import com.yinzifan.data_structures._14_redblack_tree.RBTree;
import com.yinzifan.data_structures._15_hashcode.HashTable;
import com.yinzifan.data_structures.utils.FileOperation;

public class MapDemo {
    private static double testMap(Map<String, Integer> map, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.add(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
    	
//    	BSTMap<Integer, Integer> bstMap = new BSTMap<>();
//		int[] arr = new int[] { 13, 28, 77, 78, 3, 73, 24, 28, 13, 3, 89, 100, 1, 2, 28, 1 };
//		for (int i = 0; i < arr.length; i++) {
//			int r = arr[i];
//			System.out.println("Random: " + r);
//			bstMap.add(r, bstMap.contains(r) ? bstMap.get(r) + 1 : 1);
//		}
//		System.out.println("Tree Size: " + bstMap.getSize());
//		System.out.println("Frequency of 13: " + bstMap.get(13));
//		System.out.println("Frequency of 28: " + bstMap.get(28));

        String filename = "src/main/resources/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

//        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
//        double time2 = testMap(linkedListMap, filename);
//        System.out.println("Linked List Map: " + time2 + " s");
//        System.out.println();
        
        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + " s");

        RBTree<String, Integer> rbTree = new RBTree<>();
        double time4 = testMap(rbTree, filename);
        System.out.println("RBTree Map: " + time4 + " s");
        
        HashTable<String, Integer> hashTable = new HashTable<>();
        double time5 = testMap(hashTable, filename);
        System.out.println("RBTree Map: " + time5 + " s");
        
    }
}
