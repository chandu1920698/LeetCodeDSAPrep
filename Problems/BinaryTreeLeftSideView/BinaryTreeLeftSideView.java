/*
Class Name  : BinaryTreeLeftSideView
Description : This class consists of the solution for BinaryTreeLeftSideView.
Created Date: Feb 1, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: NA

Modification Log: 
Date                Name                                            Description
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeLeftSideView
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added rightSideView
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added rightSideViewIterative
--------------------------------------------------------------------------------------------------
000. Binary Tree Left Side View
Medium
9.4K
563
Companies
Given the root of a binary tree, imagine yourself standing on the left side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,2,5]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
-------------------------------------------------------------------------------------------
*/
package Problems.BinaryTreeLeftSideView;
import java.util.*;
public class BinaryTreeLeftSideView {
    List<Integer> list = new ArrayList<>();
    public List<Integer> leftSideView(TreeNode root) {
        /* 
        * Recursive Approach
         * TC : O(N)
         * SC : O(N)
        */
        leftSideViewHelper(root, 0);
        return list;
    }

    private void leftSideViewHelper(TreeNode root, int currDepth) {
        if(root == null) return ;
        if(currDepth == list.size()) {
            list.add(root.val);
        }
        leftSideViewHelper(root.left, currDepth + 1);
        leftSideViewHelper(root.right, currDepth + 1);
        return;
    }

    public List<Integer> leftSideViewIterativeApproach(TreeNode root) {
        /* 
        * Iterative Approach
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isLeftMostNodeTaken = false;
            while(size-- > 0) {
                TreeNode node = queue.pollLast();
                if(!isLeftMostNodeTaken) {
                    list.add(node.val);
                    isLeftMostNodeTaken = !isLeftMostNodeTaken;
                }
                if(node.left != null) {
                    queue.offerFirst(node.left);
                }
                if(node.right != null) {
                    queue.offerFirst(node.right);
                }
            }
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
