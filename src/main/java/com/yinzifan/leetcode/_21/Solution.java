package com.yinzifan.leetcode._21;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode resultNode = null;
    	if (l1 == null) return l2;
    	if (l2 == null) return l1;
    	if (l1.val <= l2.val) {
    		resultNode = new ListNode(l1.val);
    		l1 = l1.next;
    	} else {
    		resultNode = new ListNode(l2.val);
    		l2 = l2.next;
    	}
    	ListNode cursor = resultNode;
    	while (l1 != null || l2 != null) {
    		if (l1 == null) {
    			cursor.next = l2;
    			break;
    		}
    		if (l2 == null) {
    			cursor.next = l1;
    			break;
    		}
    		if (l1.val <= l2.val) {
    			cursor.next = new ListNode(l1.val);
    			l1 = l1.next;
    			cursor = cursor.next;
    			continue;
    		}
    		if (l1.val > l2.val) {
    			cursor.next = new ListNode(l2.val);
    			l2 = l2.next;
    			cursor = cursor.next;
    			continue;
    		}
    	}
    	return resultNode;
    }
    public static void main(String[] args) {
//		ListNode list1 = new ListNode(1);
//		list1.next = new ListNode(2);
//		list1.next.next = new ListNode(4);
//		ListNode list2 = new ListNode(1);
//		list2.next = new ListNode(3);
//		list2.next.next = new ListNode(4);
		Solution s = new Solution();
		s.mergeTwoLists(new ListNode(1), new ListNode(1));
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}