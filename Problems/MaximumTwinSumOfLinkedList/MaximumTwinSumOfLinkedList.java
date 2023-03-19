/*
Class Name  : MaximumTwinSumOfLinkedList
Description : This class consists of the solution for MaximumTwinSumOfLinkedList.
Created Date: Mar 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
Modification Log: 
Date					    Name                                            Description
Mar 19, 2022			    Chandra Sekhar Reddy Muthumula					Added Class MaximumTwinSumOfLinkedList
Mar 19, 2022			    Chandra Sekhar Reddy Muthumula					Added pairSumFastSlowPointer
Mar 19, 2022			    Chandra Sekhar Reddy Muthumula					Added pairSumStack
Mar 19, 2022			    Chandra Sekhar Reddy Muthumula					Added pairSumBestApproach 
Mar 19, 2022			    Chandra Sekhar Reddy Muthumula					Added reverseLinkedList 
--------------------------------------------------------------------------------------------------
2130. Maximum Twin Sum of a Linked List
Medium
1.6K
42
Companies
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

Example 1:


Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
Example 2:


Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
Example 3:


Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 

Constraints:

The number of nodes in the list is an even integer in the range [2, 105].
1 <= Node.val <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.MaximumTwinSumOfLinkedList;

import java.util.*;

public class MaximumTwinSumOfLinkedList {
    public int pairSumBestApproach(ListNode head) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int twinSum = 0;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode firstHead = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode nextHead = mid.next;
        mid.next = null;
        ListNode secondHead = reverseLinkedList(nextHead);
        while(firstHead != null && secondHead != null) {
            // System.out.println("node val : " + slow.val + "stack peek : " + stack.peek());
            twinSum = Math.max(twinSum, secondHead.val + firstHead.val);
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return twinSum;
    }

    private ListNode reverseLinkedList(ListNode head) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    Stack<Integer> stack;
    public int pairSumFastSlowPointer(ListNode head) {
        /* 
         * Fast and Slow pointer
         * TC : O(N)
         * SC : O(N)
        */
        stack = new Stack<>();
        int twinSum = 0;

        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null) {
            // System.out.println("node val : " + slow.val + "stack peek : " + stack.peek());
            twinSum = Math.max(twinSum, slow.val + stack.pop());
            slow = slow.next;
        }

        return twinSum;


    }

    public int pairSumStack1(ListNode head) {
        /* 
         * Brute force Approach
         * TC : O(N)
         * SC : O(N)
        */
        stack = new Stack<>();
        int twinSum = 0;
        ListNode tempHead = head;
        int listLength = 0;
        while (tempHead != null) {
            stack.push(tempHead.val);
            listLength++;
            tempHead = tempHead.next;
        }
        tempHead = head;

        for (int i = 0; i < listLength / 2; i++) {
            // System.out.println("node val : " + tempHead.val + "stack peek : " + stack.peek());
            twinSum = Math.max(twinSum, tempHead.val + stack.pop());
            tempHead = tempHead.next;
        }

        return twinSum;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}