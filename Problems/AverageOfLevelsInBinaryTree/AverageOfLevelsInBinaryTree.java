
/*
Class Name  : AverageOfLevelsInBinaryTree
Description : This class consists of the solution for AverageOfLevelsInBinaryTree.
Created Date: Jan 27, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class AverageOfLevelsInBinaryTree
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added averageOfLevels
--------------------------------------------------------------------------------------------------
637. Average of Levels in Binary Tree
Easy
4.5K
280
Companies
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:


Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
-------------------------------------------------------------------------------------------
*/

package Problems.AverageOfLevelsInBinaryTree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    List<Double> avgList;

    public List<Double> averageOfLevels(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        avgList = new ArrayList<>();
        if (root == null) {
            return avgList;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            int size = stack.size();
            double avg = 0.0;
            int count = 0;
            while (count++ < size) {
                root = stack.pollLast();
                avg += root.val;

                if (root.left != null) {
                    stack.offerFirst(root.left);
                }
                if (root.right != null) {
                    stack.offerFirst(root.right);
                }
            }
            avg /= size;
            avgList.add(avg);
        }
        return avgList;
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
