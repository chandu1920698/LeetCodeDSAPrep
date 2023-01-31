/*
Class Name  : TrimBinarySearchTree
Description : This class consists of the solution for TrimBinarySearchTree.
Created Date: Jan 30, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/trim-a-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class TrimBinarySearchTree
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added trimBST
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added trimBSTHelper
--------------------------------------------------------------------------------------------------
669. Trim a Binary Search Tree
Medium
5.2K
246
Companies
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:


Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104
-------------------------------------------------------------------------------------------
*/
package Problems.TrimBinarySearchTree;

public class TrimBinarySearchTree {
    /*
     * TC : O(N)
     * SC : O(N)
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        return trimBSTHelper(root, low, high);
    }

    private TreeNode trimBSTHelper(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        root.left = trimBSTHelper(root.left, low, high);
        root.right = trimBSTHelper(root.right, low, high);
        if (root.val > high || root.val < low) {
            // return root.left == null ? root.right : root.left;
            return root.right == null ? root.left : root.right;
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