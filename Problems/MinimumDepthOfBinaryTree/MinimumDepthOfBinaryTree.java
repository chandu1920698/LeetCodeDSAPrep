/*
Class Name  : MinimumDepthOfBinaryTree
Description : This class consists of the solution for MinimumDepthOfBinaryTree.
Created Date: Jan 17, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumDepthOfBinaryTree
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added minDepthBFS
Jan 17, 2022			Chandra Sekhar Reddy Muthumula					Added minDepthDFS
--------------------------------------------------------------------------------------------------
111. Minimum Depth of Binary Tree
Easy
5.3K
1.1K
Companies
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

-------------------------------------------------------------------------------------------
*/

package Problems.MinimumDepthOfBinaryTree;

import java.util.*;

public class MinimumDepthOfBinaryTree {
    public int minDepthBFS(TreeNode root) {
        // BFS Solution
        // TC : O(N)
        // SC : O(Log N)
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // Initialize depth with 1 as we have the root already
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                root = q.poll();
                if (root.left == null && root.right == null) {
                    return depth;
                }

                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepthDFS(TreeNode root) {
        // DFS Solution
        // TC : O(N)
        // SC : O(Log N)
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null) {
            return 1 + minDepthDFS(root.right);
        }
        if (root.right == null) {
            return 1 + minDepthDFS(root.left);
        }
        return 1 + Math.min(minDepthDFS(root.left), minDepthDFS(root.right));
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