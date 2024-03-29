package com.yinzifan.algorithm.labuladong.homeworks._01_generateBinaryNumber;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().generateBinaryNumber(3));
    }

//    0         1
//  0   1   0       1
// 0 1 0 1 0 1    0  1

    List<String> generateBinaryNumber(int n) {
        StringBuilder sb = new StringBuilder();
        generateBinaryNumber(sb, n);
        return result;
    }

    void generateBinaryNumber(StringBuilder sb, int n) {
        if (n == 0) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            generateBinaryNumber(sb, n - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
