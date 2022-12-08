/*
Class Name  : MergeTwoSortedLists
Description : This class consists of the solution for MergeTwoSortedLists.
Date        : Dec 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/merge-two-sorted-lists/description/

Modification Log: 
Date				    Name                                            Description
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class MergeTwoSortedLists
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added mergeTwoLists
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added dislplayList
--------------------------------------------------------------------------------------------------
21. Merge Two Sorted Lists
Easy
16.3K
1.4K
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
-------------------------------------------------------------------------------------------
*/
package Problems.MergeTwoSortedLists;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        ListNode node = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                node = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                node.next = list2;
                node = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                node = list1;
                list1 = list1.next;
                node.next = list2;
                node = list2;
                list2 = list2.next;
            }
            // dislplayList(head.next);
        }
        
        while (list1 != null) {
            node.next = list1;
            node = list1;
            list1 = list1.next;
        }
        // dislplayList(head.next);
        while (list2 != null) {
            node.next = list2;
            node = list2;
            list2 = list2.next;
        }
        // dislplayList(head.next);
        return head.next;
    }

    public void dislplayList(ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println(" END ");
    }
}