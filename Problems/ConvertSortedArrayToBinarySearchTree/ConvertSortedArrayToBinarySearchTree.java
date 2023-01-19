/*
Class Name  : ConvertSortedArrayToBinarySearchTree
Description : This class consists of the solution for ConvertSortedArrayToBinarySearchTree.
Created Date: Jan 19, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class ConvertSortedArrayToBinarySearchTree
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added sortedArrayToBST
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added bst
--------------------------------------------------------------------------------------------------
108. Convert Sorted Array to Binary Search Tree
Easy
8.9K
452
Companies
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
-------------------------------------------------------------------------------------------
*/
package Problems.ConvertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
         * TC : O(Log N)
         * SC : O(N)
         */
        int len = nums.length;
        if (len == 0)
            return null;
        if (len == 1) {
            return new TreeNode(nums[0]);
        }

        return bst(nums, 0, len - 1);
    }

    private TreeNode bst(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + ((end - start) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, start, mid - 1);
        node.right = bst(nums, mid + 1, end);
        return node;
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