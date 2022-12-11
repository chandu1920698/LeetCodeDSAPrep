/*
Class Name  : ReorderList
Description : This class consists of the solution for ReorderList.
Created Date: Dec 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/reorder-list/description/

Modification Log: 
Date                Name                                            Description
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added Class ReorderList
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added reorderList
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added getMiddle
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added reverseList
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added display
--------------------------------------------------------------------------------------------------
143. Reorder List
Medium
7.7K
267
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.ReorderList;

public class ReorderList {
    
    public void reorderList(ListNode head) {
        ListNode middleNode = getMiddle(head);
        ListNode hs = reverseList(middleNode);
        ListNode hf = head;

        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null) {
            hf.next = null;
        }
        return;
    }

    private ListNode reverseList (ListNode head) {
        ListNode node = head;
        if (node == null) return head;

        ListNode prev = null;
        ListNode present = node;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next; 
            if (next != null) {
                next = next.next;
            }
        }
        return prev;

    }
    private ListNode getMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private void displayList (ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");
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
