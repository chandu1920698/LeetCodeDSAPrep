/*
Class Name  : RemoveDuplicatesFromSortedList
Description : This class consists of the solution for RemoveDuplicatesFromSortedList.
Date        : Dec 6, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

Modification Log: 
Date				    Name                                            Description
Dec 6, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveDuplicatesFromSortedList
Dec 6, 2022			Chandra Sekhar Reddy Muthumula					Added deleteDuplicates
--------------------------------------------------------------------------------------------------
83. Remove Duplicates from Sorted List
Easy
6.4K
222
Companies
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
-------------------------------------------------------------------------------------------
*/
package Problems.RemoveDuplicatesFromSortedList;

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

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cNode = head;
        if (head == null)
            return head;
        while (cNode.next != null) {
            if (cNode.val == cNode.next.val) {
                cNode.next = cNode.next.next;
            } else {
                cNode = cNode.next;
            }
        }
        return head;
    }
}