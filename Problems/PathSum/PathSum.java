/*
Class Name  : PathSum
Description : This class consists of the solution for PathSum.
Created Date: Jan 18, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/path-sum/description/

Modification Log: 
Date				    Name                                            Description
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class PathSum
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added hasPathSumIterative
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added hasPathSumRecursion
--------------------------------------------------------------------------------------------------
112. Path Sum
Easy
7.7K
908
Companies
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.PathSum;

import java.util.*;

public class PathSum {
    public boolean hasPathSumIterative(TreeNode root, int targetSum) {
        /* 
         * TC : O(N)
         * SC : O(N + N)
        */
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        stack.push(root);
        sum.push(root.val);

        while (!stack.isEmpty()) {
            int cSum = sum.pop();
            root = stack.pop();

            if (cSum == targetSum && root.left == null && root.right == null) {
                return true;
            }
            if (root.left != null) {
                stack.push(root.left);
                sum.push(cSum + root.left.val);
            }
            if (root.right != null) {
                stack.push(root.right);
                sum.push(cSum + root.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else {
            return hasPathSumRecursion(root.left, targetSum - root.val)
                    || hasPathSumRecursion(root.right, targetSum - root.val);
        }
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