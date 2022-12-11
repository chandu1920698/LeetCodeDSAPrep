/*
Class Name  : ReverseNodesInkGroup
Description : This class consists of the solution for ReverseNodesInkGroup.
Created Date: Dec 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/reverse-nodes-in-k-group/description/

Modification Log: 
Date                Name                                            Description
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added Class ReverseNodesInkGroup
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added reverseKGroup
--------------------------------------------------------------------------------------------------
25. Reverse Nodes in k-Group
Hard
9.9K
554
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
-------------------------------------------------------------------------------------------
*/
package Problems.ReverseNodesInkGroup;

public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 ||  head == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (true) {
            ListNode last = prev;
            ListNode newEnd = curr;
            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = curr;

            if (curr == null) {
                break;
            }
            prev = newEnd;

            ListNode node = curr;
            int remItems = 0;
            while (node != null) {
                remItems++;
                node = node.next;
                if (remItems == k){
                    break;
                }
            }
            if (remItems < k) {
                break;
            }
        }
    return head;
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
