/*
Class Name  : LinkedListCycle2
Description : This class consists of the solution for LinkedListCycle2.
Date        : Dec 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/linked-list-cycle-ii/description/

Modification Log: 
Date                Name                                            Description
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class LinkedListCycle2
Dec 9, 2022			Chandra Sekhar Reddy Muthumula					Added detectCycle
--------------------------------------------------------------------------------------------------
142. Linked List Cycle II
Medium
9.6K
682
Companies
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
-------------------------------------------------------------------------------------------
*/
package Problems.LinkedListCycle2;

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

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        /* Initialize the fast and slow pointers as heads */
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        /* Find the cycle and count the length of the cycle */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                break;
            }
        }
        /* If there is no cycle then return null */
        if (length == 0)
            return null;

        /* Re-initialize the fast and slow pointers to the head */
        slow = head;
        fast = head;
        /* Move the slow pointer length times ahead */
        while (length-- > 0) {
            slow = slow.next;
        }
        /*
         * Now move the slow and fast pointers one step at a time so that they meet at
         * one node,
         * which is our start node of the cycle
         */
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
