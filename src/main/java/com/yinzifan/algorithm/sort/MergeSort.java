package com.yinzifan.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] testCase = new int[] { 5, 6, 1, 2, 3, 4, 6, 7, 1, 2, 3, 1, 6, 12, 6, 7, 8, 9, 3, 4, 1 };
        mergeSort.sort(testCase);
        String result = Arrays.stream(testCase).mapToObj(Integer::toString).collect(Collectors.joining(","));
        System.out.println(result);
    }

    public void sort(int[] A) {
        mergeSort(A, 0, A.length);
    }

    private void mergeSort(int[] A, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A, mid, right);
        merge(A, left, mid, right);
    }

    // 2, 5, 3, 1, 5, 2, 3, 4
    //    1        5

    // 1 3 5 7
    // 2 4 6 8

    // 5 1 3 5 7 2 4 6 8
    // 0 1 2 3 4 5 6 7 8

    private void merge(int[] A, int left, int mid, int right) {
        int[] B = Arrays.copyOfRange(A, left, mid + 1);
        int[] C = Arrays.copyOfRange(A, mid, right + 1);
        B[B.length - 1] = C[C.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (B[i] < C[j]) {
                A[k] = B[i++];
            } else {
                A[k] = C[j++];
            }
        }
    }
}
