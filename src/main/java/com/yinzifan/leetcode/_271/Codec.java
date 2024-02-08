package com.yinzifan.leetcode._271;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/encode-and-decode-strings/description/">https://leetcode.cn/problems/encode-and-decode-strings/description/</a>
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p>
 * Machine 1 (sender) has the function:
 * <p>
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * So Machine 1 does:
 * <p>
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * <p>
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * <p>
 * Implement the encode and decode methods.
 * <p>
 * You are not allowed to solve the problem using any serialize methods (such as eval).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dummy_input = ["Hello","World"]
 * Output: ["Hello","World"]
 * Explanation:
 * Machine 1:
 * Codec encoder = new Codec();
 * String msg = encoder.encode(strs);
 * Machine 1 ---msg---> Machine 2
 * <p>
 * Machine 2:
 * Codec decoder = new Codec();
 * String[] strs = decoder.decode(msg);
 * Example 2:
 * <p>
 * Input: dummy_input = [""]
 * Output: [""]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] contains any possible characters out of 256 valid ASCII characters.
 * <p>
 * <p>
 * Follow up: Could you write a generalized algorithm to work on any possible set of characters?
 */
public class Codec {

    public static void main(String[] args) {
        Codec solution = new Codec();
        String s = solution.encode(List.of("C#", "&", "~Xp|F", "R4QBf9g=_"));
        System.out.println(solution.decode(s));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            Integer length = str.length();
            sb.append(length)
                    .append("#")
                    .append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length(); ) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int number = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + number);
            result.add(str);
            i = j + str.length() + 1;
        }
        return result;
    }
}
