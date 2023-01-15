/*
Class Name  : SameTree
Description : This class consists of the solution for SameTree.
Created Date: Jan 15, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/same-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class SameTree
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isSameTreeRecursive
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isSameTreeIterative
--------------------------------------------------------------------------------------------------
100. Same Tree
Easy
8.7K
174
Companies
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

-------------------------------------------------------------------------------------------
*/
package Problems.SameTree;

import java.util.*;

public class SameTree {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;
        return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }

    public boolean isSameTreeIterarive(TreeNode p, TreeNode q) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if (p != null)
            stack_p.push(p);
        if (q != null)
            stack_q.push(q);
        while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
            TreeNode pn = stack_p.pop();
            TreeNode qn = stack_q.pop();
            if (pn == null && qn == null) {
                continue;
            }
            if (pn == null || qn == null || pn.val != qn.val) {
                return false;
            }
            stack_p.push(pn.right);
            stack_q.push(qn.right);
            stack_p.push(pn.left);
            stack_q.push(qn.left);
        }
        return stack_p.size() == stack_q.size();
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