/*
Class Name  : FlipEquivalentBinaryTrees
Description : This class consists of the solution for FlipEquivalentBinaryTrees.
Created Date: Mar 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/flip-equivalent-binary-trees/description/
Modification Log: 
Date					    Name                                            Description
Mar 11, 2022			    Chandra Sekhar Reddy Muthumula					Added Class FlipEquivalentBinaryTrees
Mar 11, 2022			    Chandra Sekhar Reddy Muthumula					Added flipEquiv 
--------------------------------------------------------------------------------------------------
951. Flip Equivalent Binary Trees
Medium
2K
88
Companies
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

 

Example 1:

Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Example 2:

Input: root1 = [], root2 = []
Output: true
Example 3:

Input: root1 = [], root2 = [1]
Output: false
 

Constraints:

The number of nodes in each tree is in the range [0, 100].
Each tree will have unique node values in the range [0, 99].
------------------------------------------------------------------------------------------------------
*/
package Problems.FlipEquivalentBinaryTrees;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root1 == root2) {
            return true;
        }
        if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||  (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) ;
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