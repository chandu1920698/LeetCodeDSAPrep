/*
Class Name  : LRUCache
Description : This class consists of the solution for LRUCache.
Created Date: Mar 2, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/lru-cache/description/
Modification Log: 
Date					    Name                                            Description
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added Class LRUCache
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added get
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added put
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added add
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added remove
Mar  2, 2022			    Chandra Sekhar Reddy Muthumula					Added Class Node
--------------------------------------------------------------------------------------------------
146. LRU Cache
Medium
16.7K
744
Companies
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
------------------------------------------------------------------------------------------------------
*/
package Problems.LRUCache;

import java.util.*;

public class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    int cacheCapacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (map.size() == this.cacheCapacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            add(newNode);
        }

    }

    public void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;

        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }

    private class Node {
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {
            this(0, 0);
        }
    }
}