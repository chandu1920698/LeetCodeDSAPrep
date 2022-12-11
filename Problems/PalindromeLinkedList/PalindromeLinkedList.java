/*
Class Name  : PalindromeLinkedList
Description : This class consists of the solution for PalindromeLinkedList.
Created Date: Dec 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/palindrome-linked-list/description/

Modification Log: 
Date                Name                                            Description
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class PalindromeLinkedList
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added isPalindromeStackApproach
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added isPalindromeBestApproach
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added reverseList
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added display
--------------------------------------------------------------------------------------------------
234. Palindrome Linked List
Easy
12.6K
701
Companies
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
-------------------------------------------------------------------------------------------
*/
package Problems.PalindromeLinkedList;

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

public class PalindromeLinkedList {

    public boolean isPalindromeBestApproach(ListNode head) {
        /* Step 1 : Find the middle of the linked list */
        ListNode middleNode = getMiddle(head);        
        /* Reverse the List from the middle of the liked list */
        ListNode secondHead = reverseList(middleNode);

        ListNode tempHead = head;
        ListNode tempSecondHead = secondHead;
        Boolean isPalindromeCheck = true;
        /* Check each node for the value, for a palindrome */
        while(tempHead != null && tempSecondHead != null) {
            if (tempHead.val != tempSecondHead.val) {
                isPalindromeCheck = false;
                break;
            }
            tempHead = tempHead.next;
            tempSecondHead = tempSecondHead.next;
        }
        return isPalindromeCheck;
    }

    private ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode tempNode = new ListNode(node.val);
            tempNode.next = revHead;
            revHead = tempNode;
            node = node.next;
        }
        return revHead;
    }

    private void display(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindromeStackApproach(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode node = head;

        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        node = head;
        while (!stack.isEmpty()) {
            if (stack.pop() != node.val)
                return false;
            node = node.next;
        }

        return true;
    }

    public boolean isPalindromeBruteForce(ListNode head) {
        /*
         * Best TC : O(N) + O(N)
         * Worst TC : O(N) + O(N)
         * SC : O(N)
        */
        ListNode revHead = new ListNode(-1);
        revHead.next = null;
        ListNode node = head;
        while(node != null) {
            ListNode tempNode = new ListNode(node.val);
            tempNode.next = revHead;
            revHead = tempNode;
            node = node.next;
        }
        ListNode palindromeHead = revHead;
        ListNode listTempHead = head;
        while(listTempHead != null) {
            if (palindromeHead.val != listTempHead.val) {
                return false;
            }
            listTempHead = listTempHead.next;
            palindromeHead = palindromeHead.next;
        }

        return true;
    }
}