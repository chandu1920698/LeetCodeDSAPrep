/*
Class Name  : PopulatingNextRightPointersInEachNode2
Description : This class consists of the solution for PopulatingNextRightPointersInEachNode2.
Created Date: Jan 28, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

Modification Log: 
Date				    Name                                            Description
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added Class PopulatingNextRightPointersInEachNode2
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added connectIterative
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added connect
--------------------------------------------------------------------------------------------------
117. Populating Next Right Pointers in Each Node II
Medium
5.1K
292
Companies
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
 

Follow-up:

You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

-------------------------------------------------------------------------------------------
*/
package Problems.PopulatingNextRightPointersInEachNode2;

import java.util.*;

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        /*
        * TC : O(N)
        * SC : O(1)
        */
        if (root == null) return root;

	    Node head = root;

        while (head != null) {

            Node dummyNodeHead = new Node();
            Node temp = dummyNodeHead;

            // while traversing head in upper level, we process links in next level with temp pointer
            // for each level, traverse like linkedlist and form connection of next pointer
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }

            // now we reach the end of current level indicated by head pointer to null
            // now we have to point head to first node in next level
            // since dummyNodeHead was at first position in each level, 
            // other links were processed by temp pointer in that level preserving dummy node initial position
            head = dummyNodeHead.next; 
            // if(head != null) {
            //     System.out.println(head.val);
            // }
            // in the last level, since both if condition inside 2nd while loop won't execute so 
            // temp will not move hence, dummyNodeHead will also be unchanged, 
            // so next pointer of it will be null
            // thus when we do head=dummyNodeHead.next, this will give null & hence terminates the 1st while loop
        }

	return root;
    }
    public Node connectIterative(Node root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if (root == null) {
            return null;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.offerLast(root);

        while (!list.isEmpty()) {
            int size = list.size();
            while (size-- > 0) {
                Node node = list.pollLast();
                if (size != 0) {
                    node.next = list.peekLast();
                }
                if (node.left != null) {
                    list.offerFirst(node.left);
                }
                if (node.right != null) {
                    list.offerFirst(node.right);
                }
            }
        }
        return root;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
