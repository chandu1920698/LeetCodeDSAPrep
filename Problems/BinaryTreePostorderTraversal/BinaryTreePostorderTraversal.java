/*
Class Name  : BinaryTreePostorderTraversal
Description : This class consists of the solution for BinaryTreePostorderTraversal.
Created Date: Jan 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/

Modification Log: 
Date				    Name                                            Description
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreePostorderTraversal
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added postorderTraversal
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added postorderTraversalHelper
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added preorderTraversal
--------------------------------------------------------------------------------------------------
145. Binary Tree Postorder Traversal
Easy
5.5K
163
Companies
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreePostorderTraversal;

import java.util.*;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
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