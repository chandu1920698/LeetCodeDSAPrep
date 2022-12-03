/*
Class Name  : MiddleOfTheLinkedList
Description : This class consists of the solution for MiddleOfTheLinkedList.
Date        : Dec 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/middle-of-the-linked-list/description/

Modification Log: 
Date				    Name                                            Description
Dec 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class MiddleOfTheLinkedList
Dec 3, 2022			Chandra Sekhar Reddy Muthumula					Added middleNode
--------------------------------------------------------------------------------------------------
876. Middle of the Linked List
Easy
7.7K
218
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

-------------------------------------------------------------------------------------------
*/


package Problems.MiddleOfTheLinkedList;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/*
 * Definition for singly-linked list.
*/
 
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 