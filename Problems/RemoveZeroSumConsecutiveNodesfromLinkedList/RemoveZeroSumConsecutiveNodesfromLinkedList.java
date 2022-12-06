/*
Class Name  : RemoveZeroSumConsecutiveNodesfromLinkedList
Description : This class consists of the solution for RemoveZeroSumConsecutiveNodesfromLinkedList.
Date        : Dec 6, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/

Modification Log: 
Date				    Name                                            Description
Dec 6, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveZeroSumConsecutiveNodesfromLinkedList
Dec 6, 2022			Chandra Sekhar Reddy Muthumula					Added removeZeroSumSublists
--------------------------------------------------------------------------------------------------
1171. Remove Zero Sum Consecutive Nodes from Linked List
Medium
1.7K
80
Companies
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 

Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.
-------------------------------------------------------------------------------------------
*/

package Problems.RemoveZeroSumConsecutiveNodesfromLinkedList;

import java.util.*;

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

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumNodeMap = new HashMap<>();
        ListNode cNode = head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = cNode;
        int prefixSum = 0;
        sumNodeMap.put(prefixSum, dummyNode);
        while (cNode != null) {
            prefixSum += cNode.val;
            if (sumNodeMap.containsKey(prefixSum)) {
                /* Remove the entries from the HashMap */
                int tempSum = prefixSum;
                tempSum += sumNodeMap.get(prefixSum).next.val;
                while (tempSum != prefixSum) {
                    ListNode toRemovedNode = sumNodeMap.remove(tempSum);
                    tempSum += toRemovedNode.next.val;
                }
                // Delete the element from the linked list
                sumNodeMap.get(prefixSum).next = cNode.next;
            } else {
                sumNodeMap.put(prefixSum, cNode);
            }
            cNode = cNode.next;
        }
        return dummyNode.next;

    }
}