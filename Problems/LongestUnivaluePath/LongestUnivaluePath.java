/*
Class Name  : LongestUnivaluePath
Description : This class consists of the solution for LongestUnivaluePath.
Created Date: Feb 1, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/longest-univalue-path/description/

Modification Log: 
Date				    Name                                            Description
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestUnivaluePath
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added longestUnivaluePath
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added longestUnivaluePathHelper
--------------------------------------------------------------------------------------------------
687. Longest Univalue Path
Medium
3.7K
643
Companies
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [5,4,5,1,1,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 5).
Example 2:


Input: root = [1,4,5,4,4,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 4).
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.
-------------------------------------------------------------------------------------------
*/

package Problems.LongestUnivaluePath;

public class LongestUnivaluePath {
    int maxPath = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return 0;
        }
        longestUnivaluePathHelper(root, root.val);
        return  maxPath;
    }

    private int longestUnivaluePathHelper(TreeNode node, int valPrevNode) {
        if(node == null) {
            return 0;
        }

        int left = longestUnivaluePathHelper(node.left, node.val);
        int right = longestUnivaluePathHelper(node.right, node.val);
        maxPath = Math.max(maxPath, left + right);
        if(node.val == valPrevNode) {
            return Math.max(left, right) + 1;
        }
        return 0;
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