/*
Class Name  : DistributeCoinsInBinaryTree
Description : This class consists of the solution for DistributeCoinsInBinaryTree.
Created Date: Jan 31, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/distribute-coins-in-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class DistributeCoinsInBinaryTree
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added distributeCoins
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added distributeCoinsHelper
--------------------------------------------------------------------------------------------------
979. Distribute Coins in Binary Tree
Medium
4.4K
145
Companies
You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.

Return the minimum number of moves required to make every node have exactly one coin.

 

Example 1:


Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
Example 2:


Input: root = [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one coin from the root of the tree to the right child.
 

Constraints:

The number of nodes in the tree is n.
1 <= n <= 100
0 <= Node.val <= n
The sum of all Node.val is n.
-------------------------------------------------------------------------------------------
*/

package Problems.DistributeCoinsInBinaryTree;

public class DistributeCoinsInBinaryTree {
    int ans;
    public int distributeCoins(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        ans = 0;
        if(root == null) {
            return ans;
        }
        distributeCoinsHelper(root);
        return ans;
    }
    
    private int distributeCoinsHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = distributeCoinsHelper(root.left);
        int right = distributeCoinsHelper(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + right + left - 1;
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