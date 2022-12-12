/*
Class Name  : SortList
Description : This class consists of the solution for SortList.
Created Date: Dec 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/sort-list/description/

Modification Log: 
Date                Name                                            Description
Dec 12, 2022		Chandra Sekhar Reddy Muthumula					Added Class SortList
Dec 12, 2022		Chandra Sekhar Reddy Muthumula					Added sortList
Dec 12, 2022		Chandra Sekhar Reddy Muthumula					Added getMiddle
--------------------------------------------------------------------------------------------------
287. Find the Duplicate Number
Medium
17.4K
2.4K
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
-------------------------------------------------------------------------------------------
*/
package Problems.SortList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // step 1. cut the list to two halves
        ListNode mid = getMiddle(head);
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1; 
                node = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                node = l1;
                l1 = l1.next;
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            node.next = l1;
            node = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            node.next = l2;
            node = l2;
            l2 = l2.next;
        }
        
        return head.next;
    }

    private ListNode getMiddle (ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
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