package com.yinzifan.leetcode._14;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
    	String result = "";
    	if (strs.length == 0) {
    		return "";
    	}
    	result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (result.length() == 0) {
            	return "";
            } else {
            	String str = strs[i];
            	if (str.length() < result.length()) {
            		result = result.substring(0, str.length());
            	}
            	for (int j = 0; j < result.length(); j ++) {
            		char testChar = str.charAt(j);
            		if (testChar != result.charAt(j)) {
            			result = result.substring(0, j);
            		}
            	}
            }
        }       
        return result;
    }
    
}
