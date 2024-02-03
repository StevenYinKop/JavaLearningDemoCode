package com.yinzifan.leetcode._146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Node> cache;
    private final int capacity;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        left = null;
        right = null;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        lRUCache.get(1);
        lRUCache.get(2);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        evictValue(key);
        put(key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            get(key);
        } else {
            if (cache.size() == capacity) {
                evictValue(left.key);
            }
            // put it into hashmap
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            // connect the node to the left
            if (right != null) {
                right.next = newNode;
                newNode.prev = right;
            }
            right = newNode;
        }
        if (left == null) {
            left = right;
        }
    }

    private void evictValue(int key) {
        // remove it from hashMap
        Node removedNode = cache.remove(key);
        if (removedNode == left) {
            left = removedNode.next;
            removedNode.next = null;
            if (left != null) {
                left.prev = null;
            }
        }
        if (removedNode == right) {
            right = removedNode.prev;
            removedNode.prev = null;
            if (right != null) {
                right.next = null;
            }
        }
        if (removedNode.prev != null) {
            removedNode.prev.next = removedNode.next;
        }
        if (removedNode.next != null) {
            removedNode.next.prev = removedNode.prev;
        }
        removedNode.next = null;
        removedNode.prev = null;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("{%d=%d}", key, value);
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
