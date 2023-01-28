/*
Class Name  : PopulatingNextRightPointersInEachNode
Description : This class consists of the solution for PopulatingNextRightPointersInEachNode.
Created Date: Jan 28, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

Modification Log: 
Date				    Name                                            Description
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added Class PopulatingNextRightPointersInEachNode
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added goodNodes
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added goodNodesHelper
--------------------------------------------------------------------------------------------------
116. Populating Next Right Pointers in Each Node
Medium
8.2K
278
Companies
You are given a perfect binary tree where all leaves are on the same level, 
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A),
 your function should populate each next pointer to point to its next right node, just like in Figure B. 
 The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
 

Follow-up:

You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
-------------------------------------------------------------------------------------------
*/
package Problems.PopulatingNextRightPointersInEachNode;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    /*
     * TC : O(N)
     * SC : O(N)
     */
    public Node connectRecursive(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }

        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }

    public Node connectIterative(Node root) {
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
