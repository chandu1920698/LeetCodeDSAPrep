/*
Class Name  : ConstructBSTFromPreorderTraversal
Description : This class consists of the solution for ConstructBSTFromPreorderTraversal.
Created Date: Jan 26, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Modification Log: 
Date				    Name                                            Description
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class ConstructBSTFromPreorderTraversal
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added bstFromPreorderRecursive
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added bstFromPreorderHelper
--------------------------------------------------------------------------------------------------
1008. Construct Binary Search Tree from Preorder Traversal
Medium
4.9K
64
Companies
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), 
construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree 
with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, 
any descendant of Node.left has a value strictly less than Node.val, 
and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, 
then traverses Node.right.

 

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Example 2:

Input: preorder = [1,3]
Output: [1,null,3]
 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
-------------------------------------------------------------------------------------------
*/

package Problems.ConstructBSTFromPreorderTraversal;

public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorderRecursive(int[] preorder) {

        /* 
         * TC : O(N)
         * SC : O(N)
        */
        return bstFromPreorderHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorderHelper(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[start]);
        int tempStart = start + 1;
        while(start < end && root.val > arr[tempStart]) tempStart++;
        root.left = bstFromPreorderHelper(arr, start + 1, tempStart - 1);
        root.right = bstFromPreorderHelper(arr, tempStart, end);
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
