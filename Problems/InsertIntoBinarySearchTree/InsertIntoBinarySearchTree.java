/*
Class Name  : InsertIntoBinarySearchTree
Description : This class consists of the solution for InsertIntoBinarySearchTree.
Created Date: Jan 26, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class InsertIntoBinarySearchTree
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added lowestCommonAncestor
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added lowestCommonAncestorBST
--------------------------------------------------------------------------------------------------
701. Insert into a Binary Search Tree
Medium
4.5K
156
Companies
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
-------------------------------------------------------------------------------------------
*/
package Problems.InsertIntoBinarySearchTree;

public class InsertIntoBinarySearchTree {

    public TreeNode insertIntoBSTRecursiveApproach(TreeNode root, int val) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val < val) {
            root.right = insertIntoBSTRecursiveApproach(root.right, val);
        } else {
            root.left = insertIntoBSTRecursiveApproach(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBSTIterativeApproach(TreeNode root, int val) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root, prev = null;
        while(curr != null) {
            prev = curr;
            if(curr.val < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        if(prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
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
