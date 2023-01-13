/*
Class Name  : BinaryTreeLevelOrderTraversal
Description : This class consists of the solution for BinaryTreeLevelOrderTraversal.
Created Date: Jan 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Modification Log: 
Date				    Name                                            Description
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeLevelOrderTraversal
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added levelOrder
--------------------------------------------------------------------------------------------------
102. Binary Tree Level Order Traversal
Medium
12K
235
Companies
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreeLevelOrderTraversal;
import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }

            list.add(subList);
        }
        return list;
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