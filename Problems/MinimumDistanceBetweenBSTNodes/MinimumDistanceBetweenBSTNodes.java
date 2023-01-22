/*
Class Name  : MinimumDistanceBetweenBSTNodes
Description : This class consists of the solution for MinimumDistanceBetweenBSTNodes.
Created Date: Jan 22, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

Modification Log: 
Date				    Name                                            Description
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumDistanceBetweenBSTNodes
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added minDiffInBSTRecursive
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added minDiffInBSTInterative
--------------------------------------------------------------------------------------------------
783. Minimum Distance Between BST Nodes
Easy
2K
340
Companies
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105
 

Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
-------------------------------------------------------------------------------------------
*/
package Problems.MinimumDistanceBetweenBSTNodes;
import java.util.*;
public class MinimumDistanceBetweenBSTNodes {
    int minDiff = Integer.MAX_VALUE;
    int currentNodeValue = -1;
    public int minDiffInBSTRecursive(TreeNode root) {
        /* 
         * Recursive Apporach
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return 0;
        }
        if(root != null) {
            minDiffInBSTRecursive(root.left);
        }
        if(currentNodeValue >= 0) {
            minDiff = Math.min(minDiff, Math.abs(root.val - currentNodeValue));
        }
        currentNodeValue = root.val;

        if(root.right != null) {
            minDiffInBSTRecursive(root.right);
        }
        return minDiff;
    }

    public int minDiffInBSTInterative(TreeNode root) {
        /* 
         * Iterative Apporach
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }

        // Get the root values into list
        List<Integer> list = new ArrayList<Integer>();
        int minDiff = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(list.get(i - 1) - list.get(i)));
        }
        return minDiff;
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
