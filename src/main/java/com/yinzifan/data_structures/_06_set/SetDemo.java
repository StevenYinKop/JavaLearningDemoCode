package com.yinzifan.data_structures._06_set;

import java.util.ArrayList;

import com.yinzifan.data_structures._06_set.impl.AVLSet;
import com.yinzifan.data_structures._06_set.impl.BSTSet;
import com.yinzifan.data_structures._06_set.impl.LinkedListSet;
import com.yinzifan.data_structures.utils.FileOperation;

public class SetDemo {
    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src/main/resources/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");
        
        System.out.println();
        
        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("Linked List Set: " + time3 + " s");

    }
}
