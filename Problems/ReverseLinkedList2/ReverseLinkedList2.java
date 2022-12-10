/*
Class Name  : ReverseLinkedList2
Description : This class consists of the solution for ReverseLinkedList2.
Date        : Dec 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/reverse-linked-list-ii/description/

Modification Log: 
Date                    Name                                            Description
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class ReverseLinkedList2
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added reverseBetween
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added display
--------------------------------------------------------------------------------------------------
92. Reverse Linked List II
Medium
8.4K
372
Companies
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?
-------------------------------------------------------------------------------------------
*/
package Problems.ReverseLinkedList2;

import java.util.*;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode prev = temp;
        ListNode curr = head;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
            curr = curr.next;
        }

        while (prev != null && left++ < right) {
            ListNode dummy = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = dummy;
        }

        return temp.next;
    }

    public void display(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print(" END");
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
