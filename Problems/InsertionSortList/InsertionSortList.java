/*
Class Name  : InsertionSortList
Description : This class consists of the solution for InsertionSortList.
Created Date: Mar 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/insertion-sort-list/description/
Modification Log: 
Date					    Name                                            Description
Mar  1, 2022			    Chandra Sekhar Reddy Muthumula					Added Class InsertionSortList
Mar  1, 2022			    Chandra Sekhar Reddy Muthumula					Added insertionSortList
--------------------------------------------------------------------------------------------------
147. Insertion Sort List
Medium
2.5K
831
Companies
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000
------------------------------------------------------------------------------------------------------
*/
package Problems.InsertionSortList;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        /* 
         * TC : O(N  ^ 2)
         * SC : O(1)
        */
        if( head == null || head.next == null){
			return head;
		}
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
            dispalyList(helper.next);
		}
		
		return helper.next;
    }

    private void dispalyList(ListNode head) {
        ListNode tempHead = head;
        while(tempHead != null) {
            System.out.print(tempHead.val + " -> ");
            tempHead = tempHead.next;
        }
        System.out.println(" END");
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}