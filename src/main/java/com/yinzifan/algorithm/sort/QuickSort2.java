package com.yinzifan.algorithm.sort;

import static com.yinzifan.algorithm.sort.Helper.swap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort2 {
    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] testCase = new int[] { 5, 6, 1, 2, 3, 4, 6, 7, 1, 2, 3, 1, 6, 12, 6, 7, 8, 9, 3, 4, 1 };
        quickSort2.sort(testCase);
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
        int x = A[left]; // first element
        int i = left + 1; // [left, i) < x
        int j = left + 1; // [i, j) == x
        int k = right - 1; // [k, right) > x

        while (j <= k) {
            if (A[j] == x) {
                j++;
            } else if (A[j] < x) {
                swap(A, i++, j++);
            } else {
                swap(A, k--, j);
            }
        }
        swap(A, left, i - 1);
        quickSort(A, left, i);
        quickSort(A, j, right);
    }
    // 2, 5, 3, 1, 5, 2, 3, 4
    //    1        5

    // 1 3 5 7
    // 2 4 6 8

    // 5 1 3 5 7 2 4 6 8
    // 0 1 2 3 4 5 6 7 8
}
