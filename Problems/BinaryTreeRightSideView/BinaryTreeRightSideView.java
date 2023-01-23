/*
Class Name  : BinaryTreeRightSideView
Description : This class consists of the solution for BinaryTreeRightSideView.
Created Date: Jan 23, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-tree-right-side-view/description/

Modification Log: 
Date				    Name                                            Description
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeRightSideView
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added rightSideView
--------------------------------------------------------------------------------------------------
199. Binary Tree Right Side View
Medium
9.3K
558
Companies
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
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
package Problems.BinaryTreeRightSideView;
import java.util.*;
public class BinaryTreeRightSideView {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return list;
    }

    private void helper(TreeNode root, int currDepth) {
        if(root == null) return ;
        if(currDepth == list.size()) {
            list.add(root.val);
        }

        helper(root.right, currDepth + 1);
        helper(root.left, currDepth + 1);
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
