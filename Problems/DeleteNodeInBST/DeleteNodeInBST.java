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
450. Delete Node in a BST
Medium
7.1K
179
Companies
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 

Follow up: Could you solve it with time complexity O(height of tree)?
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