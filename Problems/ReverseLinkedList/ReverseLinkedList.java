/*
Class Name  : ReverseLinkedList
Description : This class consists of the solution for ReverseLinkedList.
Date        : Dec 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/reverse-linked-list/description/

Modification Log: 
Date                Name                                            Description
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class ReverseLinkedList
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added reverseList
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added reverseListSimpleIterative
--------------------------------------------------------------------------------------------------
206. Reverse Linked List
Easy
15.8K
263
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
-------------------------------------------------------------------------------------------
*/
package Problems.ReverseLinkedList;

import java.util.*;

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

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null)
            return null;
        ListNode prev = null;
        ListNode pres = head;
        ListNode future = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = future;
            if (future != null) {
                future = future.next;
            }
        }

        head = prev;
        return head;
    }

    public ListNode reverseListSimpleIterative(ListNode head) {
        ListNode cNode = head;
        ListNode rHead = null;
        while (cNode != null) {
            ListNode node = new ListNode(cNode.val);
            node.next = rHead;
            rHead = node;
            cNode = cNode.next;
        }
        return rHead;
    }
}
