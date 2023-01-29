/*
Class Name  : BinaryTreeMaximumPathSum
Description : This class consists of the solution for BinaryTreeMaximumPathSum.
Created Date: Jan 29, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

Modification Log: 
Date				    Name                                            Description
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeMaximumPathSum
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added maxPathSum
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added helper
--------------------------------------------------------------------------------------------------
124. Binary Tree Maximum Path Sum
Hard
13.4K
627
Companies
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreeMaximumPathSum;

public class BinaryTreeMaximumPathSum {
    /* 
     * TC : O(N)
     * SC : O(N)
    */
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        helper(root);
        return maxSum;
        
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftVal = helper(root.left);
        int rightVal = helper(root.right);
        int straightPathSum = Math.max(root.val, Math.max(root.val + leftVal, root.val + rightVal));
        int curvedPath = root.val + leftVal + rightVal;
        maxSum = Math.max(maxSum, Math.max(straightPathSum, curvedPath));
        return straightPathSum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}