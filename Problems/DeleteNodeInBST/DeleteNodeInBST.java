/*
Class Name  : DeleteNodeInBST
Description : This class consists of the solution for DeleteNodeInBST.
Created Date: Mar 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/delete-node-in-a-bst/description/
Modification Log: 
Date					    Name                                            Description
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added Class DeleteNodeInBST
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added deleteNode 
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added helper 
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added getRightMostNode 
--------------------------------------------------------------------------------------------------
617. Merge Two Binary Trees
Easy
7.9K
275
Companies
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

 

Example 1:


Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]
 

Constraints:

The number of nodes in both trees is in the range [0, 2000].
-104 <= Node.val <= 104
------------------------------------------------------------------------------------------------------
*/
package Problems.DeleteNodeInBST;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        /* 
         * TC : O(log N)
         * SC : O(1)
        */
        if(root == null) {
            return null;
        }
        if(root.val == key) {
            return helper(root);
        }

        TreeNode node = root;
        while(node != null) {
            if(node.val > key) {
                if(node.left != null && node.left.val == key) {
                    node.left = helper(node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if(node.right != null && node.right.val == key) {
                    node.right = helper(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
            
        }
        return root;
    }

    private TreeNode helper(TreeNode node) {
        if(node.left == null) {
            return node.right;
        } else  if(node.right == null) {
            return node.left;
        }

        TreeNode nodeRight = node.right;
        TreeNode rightMostNode = getRightMostNode(node.left);
        rightMostNode.right = nodeRight;
        return node.left;
    }

    private TreeNode getRightMostNode(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
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