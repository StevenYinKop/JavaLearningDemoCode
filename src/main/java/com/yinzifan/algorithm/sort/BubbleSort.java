package com.yinzifan.algorithm.sort;

import static com.yinzifan.algorithm.sort.Helper.swap;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		sort(new int[] { 6, 4, 2, 8, 2, 4, 1, 9, 7, 4, 1 });
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					//进行交换操作
					swap(arr, j, j - 1);
				}
			}
			System.out.println("第" + (i + 1) + "趟排序结果: " + Arrays.toString(arr));
		}
	}
}
