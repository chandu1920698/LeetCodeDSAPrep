/*
Class Name  : SwapNodesInPairs
Description : This class consists of the solution for SwapNodesInPairs.
Created Date: Feb 28, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
Modification Log: 
Date					    Name                                            Description
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added Class SwapNodesInPairs
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added swapPairs
--------------------------------------------------------------------------------------------------
24. Swap Nodes in Pairs
Medium
9.2K
354
Companies
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
------------------------------------------------------------------------------------------------------
*/
package Problems.SwapNodesInPairs;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        /* 
         * TC : O(N / 2)
         * SC : O(1)
        */
        if(head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        if(second == null) {
            return first;
        }
        ListNode firstNext = first.next;
        ListNode prev = null;
        while(first != null && second != null) {
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            if(prev != null) {
                prev.next = second;
            }
            prev = first;
            
            first = temp;
            if(first != null) {
                second = first.next;
            }
        }
        return firstNext;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}