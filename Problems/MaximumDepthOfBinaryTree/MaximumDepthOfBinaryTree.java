/*
Class Name  : MaximumDepthOfBinaryTree
Description : This class consists of the solution for MaximumDepthOfBinaryTree.
Created Date: Jan 17, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaximumDepthOfBinaryTree
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added maxDepthApproach1
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added maxDepthApproach2
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added findDepth1
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added findDepth2
--------------------------------------------------------------------------------------------------
104. Maximum Depth of Binary Tree
Easy
9.5K
156
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
-------------------------------------------------------------------------------------------
*/
package Problems.MaximumDepthOfBinaryTree;

public class MaximumDepthOfBinaryTree {
    public int maxDepthApproach1(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) return 0;
        TreeNode tempRoot = root;
        return findDepth1(tempRoot);
    }

    private int findDepth1(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(findDepth1(node.left), findDepth1(node.right));
    }

    static int height;
    static int maxHeight;
    public int maxDepthApproach2(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) return 0;
        TreeNode tempRoot = root;
        height = 0;
        maxHeight = 0;
        findDepth2(tempRoot);
        return maxHeight;
    }

    private void findDepth2(TreeNode root) {
        if(root == null) {
            return;
        }
        height++;
        maxHeight = Math.max(maxHeight, height);
        findDepth2(root.left);
        findDepth2(root.right);
        height--;
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