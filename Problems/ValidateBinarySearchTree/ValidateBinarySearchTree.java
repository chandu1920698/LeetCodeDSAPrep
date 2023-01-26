
/*
Class Name  : ValidateBinarySearchTree
Description : This class consists of the solution for ValidateBinarySearchTree.
Created Date: Jan 15, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/validate-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidateBinarySearchTree
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isValidBST
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isAscending
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isValidBSTRecursion
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isValid
--------------------------------------------------------------------------------------------------
98. Validate Binary Search Tree
Medium
13.6K
1.1K
Companies
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
-------------------------------------------------------------------------------------------
*/

package Problems.ValidateBinarySearchTree;
import java.util.*;
public class ValidateBinarySearchTree {

    public boolean isValidBSTRecursion(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        TreeNode tempRoot = root;
        return isValid(tempRoot, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val >= max || root.val <= min) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

    }

    public boolean isValidBST(TreeNode root) {
        /* 
         * TC : O(N) + O(N)
         * SC : O(N)
        */
        List<Integer> array = new ArrayList<>();
        TreeNode tempRoot = root;
        helper(tempRoot, array);
        if(array.size() == 1) return true;
        return isAscending(array);
    }

    private void helper(TreeNode root, List<Integer> array) {
        if(root == null) {
            return;
        }
        helper(root.left, array);
        array.add(root.val);
        helper(root.right, array);
    }

    private boolean isAscending(List<Integer> array) {
        int len = array.size();
        for (int i = 1; i < len; i++) {
            if(array.get(i) <= array.get(i - 1)) {
                return false;
            }
        }
        return true;
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