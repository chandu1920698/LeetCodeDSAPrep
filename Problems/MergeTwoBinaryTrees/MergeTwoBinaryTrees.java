/*
Class Name  : MergeTwoBinaryTrees
Description : This class consists of the solution for MergeTwoBinaryTrees.
Created Date: Mar 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/merge-two-binary-trees/description/
Modification Log: 
Date					    Name                                            Description
Mar 11, 2022			    Chandra Sekhar Reddy Muthumula					Added Class MergeTwoBinaryTrees
Mar 11, 2022			    Chandra Sekhar Reddy Muthumula					Added mergeTrees 
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
package Problems.MergeTwoBinaryTrees;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
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