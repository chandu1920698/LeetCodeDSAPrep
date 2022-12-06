/*
Class Name  : RemoveLinkedListElements
Description : This class consists of the solution for RemoveLinkedListElements.
Date        : Dec 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-linked-list-elements/description/

Modification Log: 
Date				    Name                                            Description
Dec 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveLinkedListElements
Dec 5, 2022			Chandra Sekhar Reddy Muthumula					Added removeNthFromEnd
--------------------------------------------------------------------------------------------------
19. Remove Nth Node From End of List
Medium
14K
580
Companies
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
-------------------------------------------------------------------------------------------
*/

package Problems.RemoveLinkedListElements;

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head, prev = dummyHead;
        while (curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}