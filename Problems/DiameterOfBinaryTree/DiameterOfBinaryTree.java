/*
Class Name  : DiameterOfBinaryTree
Description : This class consists of the solution for DiameterOfBinaryTree.
Created Date: Jan 18, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/diameter-of-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class DiameterOfBinaryTree
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added isBalanced
--------------------------------------------------------------------------------------------------
543. Diameter of Binary Tree
Easy
10.5K
664
Companies
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
-------------------------------------------------------------------------------------------
*/

package Problems.DiameterOfBinaryTree;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // TC : O(N)
        // SC : O(N)
        if(root == null) return 0;

        getHeight(root);
        return this.diameter;

    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        this.diameter = Math.max(this.diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
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