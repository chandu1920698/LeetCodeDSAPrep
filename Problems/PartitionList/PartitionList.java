/*
Class Name  : PartitionList
Description : This class consists of the solution for PartitionList.
Created Date: Mar 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/partition-list/description/
Modification Log: 
Date					    Name                                            Description
Mar  1, 2022			    Chandra Sekhar Reddy Muthumula					Added Class PartitionList
Mar  1, 2022			    Chandra Sekhar Reddy Muthumula					Added partition
--------------------------------------------------------------------------------------------------
86. Partition List
Medium
5.2K
616
Companies
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
------------------------------------------------------------------------------------------------------
*/
package Problems.PartitionList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        if(head == null) {
            return null;
        }

        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x) {
                l1.next = temp;
                l1 = l1.next;
            } else {
                l2.next = temp;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        l1.next = list2.next;
        l2.next = null;
        return list1.next;

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}