/*
Class Name  : PathSum3
Description : This class consists of the solution for PathSum3.
Created Date: Jan 31, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/path-sum-iii/description/

Modification Log: 
Date				    Name                                            Description
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class PathSum3
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added pathSumApproach1
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added pathSumApproach2
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added countPaths
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added pathSumHelper
--------------------------------------------------------------------------------------------------
437. Path Sum III
Medium
9.2K
442
Companies
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.PathSum3;

import java.util.*;

public class PathSum3 {
    public int pathSumApproach1(TreeNode root, int targetSum) {
        /*
         * TC : O(N ^ 2)
         * SC : O(N)
         */
        if (root == null) {
            return 0;
        }

        return pathSumApproach1(root.left, targetSum) + pathSumApproach1(root.right, targetSum)
                + countPaths(root, (long) targetSum);
    }

    private int countPaths(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (sum == root.val) {
            count = 1;
        }

        count += countPaths(root.left, sum - root.val);
        count += countPaths(root.right, sum - root.val);
        return count;
    }

    int count;

    public int pathSumApproach2(TreeNode root, int targetSum) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        if (root == null) {
            return 0;
        }
        count = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return pathSumHelper(root, 0L, targetSum, map);
    }

    private int pathSumHelper(TreeNode root, long runningSum, int target, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        runningSum += root.val;
        count = map.getOrDefault(runningSum - target, 0);
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        count += pathSumHelper(root.left, runningSum, target, map) + pathSumHelper(root.right, runningSum, target, map);
        map.put(runningSum, map.get(runningSum) - 1);
        runningSum -= root.val;
        return count;
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