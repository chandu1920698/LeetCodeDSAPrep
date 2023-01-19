/*
Class Name  : BinaryTreeZigzagLevelOrderTraversal
Description : This class consists of the solution for BinaryTreeZigzagLevelOrderTraversal.
Created Date: Jan 19, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

Modification Log: 
Date				    Name                                            Description
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeZigzagLevelOrderTraversal
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added zigzagLevelOrder
--------------------------------------------------------------------------------------------------
103. Binary Tree Zigzag Level Order Traversal
Medium
7.9K
209
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean isNormal = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                if (isNormal) {
                    root = q.removeFirst();
                    list.add(root.val);
                    if (isNormal) {
                        if (root.left != null) {
                            q.offerLast(root.left);
                        }
                        if (root.right != null) {
                            q.offerLast(root.right);
                        }
                    }
                } else {
                    root = q.removeLast();
                    list.add(root.val);
                    if (root.right != null) {
                        q.offerFirst(root.right);
                    }
                    if (root.left != null) {
                        q.offerFirst(root.left);
                    }
                }
            }
            isNormal = !isNormal;
            lists.add(list);
        }
        return lists;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}