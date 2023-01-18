/*
Class Name  : PathSum2
Description : This class consists of the solution for PathSum.
Created Date: Jan 18, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/path-sum-ii/description/

Modification Log: 
Date				    Name                                            Description
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class PathSum2
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added pathSumBackTracking
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added helperBackTracking
Jan 18, 2022			Chandra Sekhar Reddy Muthumula					Added helper
--------------------------------------------------------------------------------------------------
113. Path Sum II
Medium
6.6K
136
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.PathSum2;

import java.util.*;

public class PathSum2 {
    List<List<Integer>> paths;

    public List<List<Integer>> pathSumBackTracking(TreeNode root, int targetSum) {
        paths = new ArrayList<List<Integer>>();
        helperBackTracking(root, targetSum, new ArrayList<Integer>());
        return paths;
    }

    private void helperBackTracking(TreeNode root, int targetSum, List<Integer> array) {
        if (root == null)
            return;
        array.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(array));
        }
        helperBackTracking(root.left, targetSum - root.val, array);
        helperBackTracking(root.right, targetSum - root.val, array);
        array.remove(array.size() - 1);
    }

    public List<List<Integer>> pathSumRecurson(TreeNode root, int targetSum) {
        paths = new ArrayList<List<Integer>>();
        helper(root, targetSum, new ArrayList<Integer>());
        return paths;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> array) {
        if (root == null)
            return;
        array.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            paths.add(array);
            return;
        } else {
            helper(root.left, targetSum - root.val, new ArrayList<>(array));
            helper(root.right, targetSum - root.val, new ArrayList<>(array));
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