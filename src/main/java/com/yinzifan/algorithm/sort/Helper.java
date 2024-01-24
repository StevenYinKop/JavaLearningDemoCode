package com.yinzifan.algorithm.sort;

public class Helper {
    public static void swap(int[] arr, int i, int j) {
        //进行交换操作
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
