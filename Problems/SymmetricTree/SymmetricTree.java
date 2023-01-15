/*
Class Name  : SymmetricTree
Description : This class consists of the solution for SymmetricTree.
Created Date: Jan 15, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/symmetric-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class SymmetricTree
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isSymmetric
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isSymmetricHelper
--------------------------------------------------------------------------------------------------
101. Symmetric Tree
Easy
12K
272
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
-------------------------------------------------------------------------------------------
*/
package Problems.SymmetricTree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        /* 
         * TC : O(N + N)
         * SC : O(N + N)
        */
        if(root == null) return true;
        TreeNode tempRoot = root;
        return isSymmetricHelper(tempRoot.left, tempRoot.right);
    }

    private boolean isSymmetricHelper(TreeNode tempRootLeft, TreeNode tempRootRight) {

        if(tempRootLeft == null && tempRootRight == null) {
            return true;
        }

        if(tempRootLeft == null || tempRootRight == null) {
            return false;
        }
        return (tempRootLeft.val == tempRootRight.val) && isSymmetricHelper(tempRootLeft.left, tempRootRight.right) && isSymmetricHelper(tempRootLeft.right, tempRootRight.left);
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