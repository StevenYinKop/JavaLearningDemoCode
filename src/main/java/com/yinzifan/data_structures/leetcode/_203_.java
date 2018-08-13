package com.yinzifan.data_structures.leetcode;
/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _203_ {
	
    public ListNode removeElements(ListNode head, int val) {
    	ListNode dummyHead = new ListNode(-1);
    	dummyHead.next = head;
    	ListNode pre = dummyHead;
    	while(pre.next != null) {
    		if(pre.next.val == val) {
    			pre.next = pre.next.next;
    		} else {
    			pre = pre.next;
    		}
    	}
    	return dummyHead.next;
    }
    public static void main(String[] args) {
    	int [] arr = {1,2,6,3,4,5,6};
    	ListNode head = new ListNode(arr[0]);
    	ListNode node = head;
    	for(int i = 1; i < arr.length; i ++) {
    		head.next = new ListNode(arr[i]);
    		head = head.next;
    	}
    	
    	StringBuilder sb = new StringBuilder();
		ListNode cur = node;
		while(cur != null) {
			sb.append(cur.val + " -> ");
			cur = cur.next;
		}
		sb.append("NULL");
    	System.out.println(sb.toString());
    	(new _203_()).removeElements(node, 6);
	}
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}