/*
Class Name  : RecoverBinarySearchTree
Description : This class consists of the solution for RecoverBinarySearchTree.
Created Date: Jan 26, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/recover-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class RecoverBinarySearchTree
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added inorderTraversal
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added recoverTree
--------------------------------------------------------------------------------------------------
99. Recover Binary Search Tree
Medium
6.6K
218
Companies
You are given the root of a binary search tree (BST), 
where the values of exactly two nodes of the tree were swapped by mistake. 
Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. 
Could you devise a constant O(1) space solution?
-------------------------------------------------------------------------------------------
*/
package Problems.RecoverBinarySearchTree;

public class RecoverBinarySearchTree {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(last == null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left);
        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorderTraversal(root.right);
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
