/*
Class Name  : RotateList
Description : This class consists of the solution for RotateList.
Date        : Dec 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/rotate-list/description/

Modification Log: 
Date                    Name                                            Description
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class RotateList
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class WrapperClassLL
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added lenghtOfLL
--------------------------------------------------------------------------------------------------
61. Rotate List
Medium
6.9K
1.3K
Companies
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
-------------------------------------------------------------------------------------------
*/
package Problems.RotateList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        WrapperClassLL data = lenghtOfLL(head);
        ListNode tail = data.tail;
        k %= data.len;

        /* Make the linked list circular */
        tail.next = head;

        int stepToMoveAhead = data.len - k;
        for (int i = 0; i < stepToMoveAhead; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    private WrapperClassLL lenghtOfLL(ListNode head) {
        WrapperClassLL data = new WrapperClassLL();
        int len = 0;
        ListNode node = new ListNode();
        node.next = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        data.len = len;
        data.tail = node;
        return data;
    }

    private class WrapperClassLL {
        int len;
        ListNode tail;
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
