/*
Class Name  : NthNodeFromEndOfLinkedList
Description : This class consists of the solution for NthNodeFromEndOfLinkedList.
Date        : Dec 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

Modification Log: 
Date				    Name                                            Description
Dec 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class NthNodeFromEndOfLinkedList
Dec 3, 2022			Chandra Sekhar Reddy Muthumula					Added getNthFromLast
--------------------------------------------------------------------------------------------------
Nth node from end of linked list
EasyAccuracy: 41.18%Submissions: 100k+Points: 2
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.  

Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end is 8.  
Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.
Your Task:
The task is to complete the function getNthFromLast() which takes two arguments: reference to head and N and you need to return Nth from the end or -1 in case node doesn't exist.

Note:
Try to solve in a single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 106
1 <= N <= 106
-------------------------------------------------------------------------------------------
*/



package Problems.NthNodeFromEndOfLinkedList;

public class NthNodeFromEndOfLinkedList {
    int getNthFromLast(Node head, int n)
    {
        Node slow = head;
        Node fast = head;
        while (n-- > 0 ) {
            if (fast == null) return -1;
            fast = fast.next;
            // System.out.print(fast.data + ", ");
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            // System.out.print(slow.data + ", ");
        }
        if(slow == null) return -1;
        else return slow.data;
    }
}

//Structure of node
class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}