/*
Class Name  : MergeKSortedLists
Description : This class consists of the solution for MergeKSortedLists.
Date        : Dec 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/merge-k-sorted-lists/description/

Modification Log: 
Date				    Name                                            Description
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class MergeKSortedLists
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added mergeTwoLists
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added mergeKLists
Dec 8, 2022			Chandra Sekhar Reddy Muthumula					Added dislplayList
--------------------------------------------------------------------------------------------------
23. Merge k Sorted Lists
Hard
15K
563
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

-------------------------------------------------------------------------------------------
*/
package Problems.MergeKSortedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        
        for (int i = 1; i < len; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
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