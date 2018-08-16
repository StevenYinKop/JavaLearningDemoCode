package com.yinzifan.data_structures.leetcode;
import java.util.Set;
import java.util.TreeSet;

public class _804_ {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new TreeSet<>();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i< word.length(); i++) {
        		String mose = codes[word.charAt(i) - 'a'];
        		sb.append(mose);
        	}
        	set.add(sb.toString());
		}
        return set.size();
	}
}
