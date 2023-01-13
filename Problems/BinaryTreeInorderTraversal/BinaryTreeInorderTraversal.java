/*
Class Name  : BinaryTreeInorderTraversal
Description : This class consists of the solution for BinaryTreeInorderTraversal.
Created Date: Jan 12, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

Modification Log: 
Date				    Name                                            Description
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeInorderTraversal
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added inorderTraversal
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added inorderTraversalHelper
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added inorderTraversalIterative
--------------------------------------------------------------------------------------------------
94. Binary Tree Inorder Traversal
Easy
10.6K
500
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreeInorderTraversal;

import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        inorderTraversalHelper(root, list);
        return list;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        // Left, Root, Right
        if (root == null)
            return;
        inorderTraversalHelper(root.left, list);
        list.add(root.val);
        inorderTraversalHelper(root.right, list);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        TreeNode tempRoot = root;
        Stack<TreeNode> stack =  new Stack<>();
        while(true) {
            if(tempRoot != null) {
                stack.push(tempRoot);
                tempRoot = tempRoot.left; 
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                tempRoot = stack.pop();
                list.add(tempRoot.val);
                tempRoot = tempRoot.right;
            }
        }
        return list;        
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
