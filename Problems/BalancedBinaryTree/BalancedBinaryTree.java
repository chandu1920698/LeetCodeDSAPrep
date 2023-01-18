/*
Class Name  : BalancedBinaryTree
Description : This class consists of the solution for BalancedBinaryTree.
Created Date: Jan 17, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/balanced-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class BalancedBinaryTree
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added isBalanced
--------------------------------------------------------------------------------------------------
110. Balanced Binary Tree
Easy
8.1K
458
Companies
Given a binary tree, determine if it is 
height-balanced

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
-------------------------------------------------------------------------------------------
*/


package Problems.BalancedBinaryTree;

import java.util.*;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        return dfsHeight(root) == -1 ? false : true;
    }

    private int dfsHeight(TreeNode root) {
        if(root == null) return 0;
        int lh = dfsHeight(root.left);
        if(lh == -1) return -1;
        int rh = dfsHeight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
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