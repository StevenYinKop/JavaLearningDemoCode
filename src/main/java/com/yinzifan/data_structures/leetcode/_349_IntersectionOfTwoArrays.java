package com.yinzifan.data_structures.leetcode;

import com.yinzifan.data_structures._01_array.Array;
import com.yinzifan.data_structures._07_map.impl.LinkedListMap;

public class _349_IntersectionOfTwoArrays {
//	Given two arrays, write a function to compute their intersection.
//	Input: nums1 = [1,2,2,1], nums2 = [2,2]
//			Output: [2]
//	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//			Output: [9,4]
    public int[] intersection(int[] nums1, int[] nums2) {
        LinkedListMap<Integer, Integer> map = new LinkedListMap<>();
        for (int i : nums1) {
        	map.add(i, null);
		}
        Array<Integer> arr = new Array<>();
        for (int i : nums2) {
        	if(map.contains(i)) {
        		arr.addLast(i);
        		map.remove(i);
        	}
		}
        int[] res = new int[arr.getSize()];
        for(int i = 0; i < res.length; i ++) {
        	res[i]  = arr.get(i);
        }
        return res;
        
    }
    
    public static void main(String[] args) {
    	_349_IntersectionOfTwoArrays c = new _349_IntersectionOfTwoArrays();
    	int[] res1 = c.intersection(new int[] {1,2,2,1}, new int[] {2,2});
    	for (int i : res1) {
			System.out.print(i + ", ");
		}
    	System.out.println();
    	int[] res2 = c.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
    	for (int i : res2) {
    		System.out.print(i + ", ");
    	}
    	System.out.println();
    	
	}
	
}
