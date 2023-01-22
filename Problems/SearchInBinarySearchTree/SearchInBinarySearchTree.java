/*
Class Name  : SearchInBinarySearchTree
Description : This class consists of the solution for SearchInBinarySearchTree.
Created Date: Jan 22, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/search-in-a-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class SearchInBinarySearchTree
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added searchBST
--------------------------------------------------------------------------------------------------
700. Search in a Binary Search Tree
Easy
4.5K
163
Companies
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
-------------------------------------------------------------------------------------------
*/
package Problems.SearchInBinarySearchTree;

public class SearchInBinarySearchTree {
    // Iterative Approach
    // TC : O(N)
    // SC : O(1)
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            if(root.val < val){
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if(root == null ||  root.val == val) {
            return root;
        } else {
            if(root.val < val) {
                root = searchBSTRecursion(root.right, val);
            } else {
                root = searchBSTRecursion(root.left, val);
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
