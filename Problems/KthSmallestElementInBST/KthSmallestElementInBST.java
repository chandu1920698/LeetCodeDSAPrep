/*
Class Name  : KthSmallestElementInBST
Description : This class consists of the solution for KthSmallestElementInBST.
Created Date: Jan 15, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Modification Log: 
Date				    Name                                            Description
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class KthSmallestElementInBST
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added kthSmallest
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added helper
--------------------------------------------------------------------------------------------------
230. Kth Smallest Element in a BST
Medium
9.1K
162
Companies
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
-------------------------------------------------------------------------------------------
*/
package Problems.KthSmallestElementInBST;

public class KthSmallestElementInBST {
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        /* 
         * TC : O(K)
         * SC : O(1)
        */
        if(root == null) return 0;
        TreeNode tempRoot = root;
        helper(tempRoot, k);
        return result;
    }
    
    private void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        
        helper(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        helper(root.right, k);
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