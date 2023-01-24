/*
Class Name  : InvertBinaryTree
Description : This class consists of the solution for InvertBinaryTree.
Created Date: Jan 24, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/invert-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class InvertBinaryTree
Jan 24, 2022			Chandra Sekhar Reddy Muthumula					Added invertTreeIterativeApproach
Jan 24, 2022			Chandra Sekhar Reddy Muthumula					Added invertTreeRecursiveApproach
Jan 24, 2022			Chandra Sekhar Reddy Muthumula					Added invertTreeHelper
--------------------------------------------------------------------------------------------------
226. Invert Binary Tree
Easy
10.8K
153
Companies
Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

-------------------------------------------------------------------------------------------
*/
package Problems.InvertBinaryTree;

import java.util.*;

public class InvertBinaryTree {

    public TreeNode invertTreeRecursiveApproach(TreeNode node) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        TreeNode root = node;
        return invertTreeHelper(root);
    }

    private TreeNode invertTreeHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = invertTreeHelper(root.left);
        root.left = invertTreeHelper(root.right);
        root.right = temp;
        return root;
    }

    public TreeNode invertTreeIterativeApproach(TreeNode root) {
        /*
         * TC : O(N)
         * SC : O(N)
        */
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
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
