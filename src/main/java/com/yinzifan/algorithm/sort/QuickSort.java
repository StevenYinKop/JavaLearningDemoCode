package com.yinzifan.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] testCase = new int[] { 5, 6, 1, 2, 3, 4, 6, 7, 1, 2, 3, 1, 6, 12, 6, 7, 8, 9, 3, 4, 1 };
        quickSort.sort(testCase);
        String result = Arrays.stream(testCase).mapToObj(Integer::toString).collect(Collectors.joining(","));
        System.out.println(result);
    }

    public void sort(int[] A) {
        quickSort(A, 0, A.length);
    }

    private void quickSort(int[] A, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        // 取出一个基准值x
        int x = A[0];
        // 取出所有比x小的值 leftArray
        int[] leftArray = Arrays.stream(A).filter(a -> a < x).toArray();
        // 取出所有和x一样大的值 midArray
        int[] midArray = Arrays.stream(A).filter(a -> a == x).toArray();
        // 取出所有比x大的值 rightArray
        int[] rightArray = Arrays.stream(A).filter(a -> a > x).toArray();
        quickSort(leftArray, 0, leftArray.length);
        quickSort(rightArray, 0, rightArray.length);
        // 将这三个数组拼接到一起去
        System.arraycopy(leftArray, 0, A, 0, leftArray.length);
        System.arraycopy(midArray, 0, A, leftArray.length, midArray.length);
        System.arraycopy(rightArray, 0, A, leftArray.length + midArray.length, rightArray.length);
    }

    // 2, 5, 3, 1, 5, 2, 3, 4
    //    1        5

    // 1 3 5 7
    // 2 4 6 8

    // 5 1 3 5 7 2 4 6 8
    // 0 1 2 3 4 5 6 7 8
}
