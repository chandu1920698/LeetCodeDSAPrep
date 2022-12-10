/*
Class Name  : AddTwoNumbersLinkedList
Description : This class consists of the solution for AddTwoNumbersLinkedList.
Date        : Dec 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/add-two-numbers/description/

Modification Log: 
Date                    Name                                            Description
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class AddTwoNumbersLinkedList
Dec 10, 2022			Chandra Sekhar Reddy Muthumula					Added addTwoNumbers
--------------------------------------------------------------------------------------------------
2. Add Two Numbers
Medium
23.2K
4.5K
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
-------------------------------------------------------------------------------------------
*/
package Problems.AddTwoNumbersLinkedList;

public class AddTwoNumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansHead = new ListNode();
        ListNode head = ansHead;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = carry + node1.val + node2.val;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            ansHead.next = node;
            ansHead = node;

            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            int sum = carry + node1.val;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            ansHead.next = node;
            ansHead = node;
            node1 = node1.next;
        }

        while (node2 != null) {
            int sum = carry + node2.val;
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            ansHead.next = node;
            ansHead = node;
            node2 = node2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            ansHead.next = node;
            ansHead = node;
        }

        return head.next;
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
