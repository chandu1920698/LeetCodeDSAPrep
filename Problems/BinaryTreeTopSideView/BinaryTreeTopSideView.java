/*
Class Name  : BinaryTreeTopSideView
Description : This class consists of the solution for BinaryTreeTopSideView.
Created Date: Feb 1, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: NA

Modification Log: 
Date                Name                                            Description
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinaryTreeTopSideView
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added helper
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added rightSideView
Feb 1, 2022			Chandra Sekhar Reddy Muthumula					Added rightSideViewIterative
--------------------------------------------------------------------------------------------------
000. Binary Tree Top Side View
Medium
9.4K
563
Companies
Given the root of a binary tree, imagine yourself standing on the Top side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [2, 1, 3, 4]
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
package Problems.BinaryTreeTopSideView;
import java.util.*;
public class BinaryTreeTopSideView {
    List<Integer> list;
    List<Integer> TopList;
    List<Integer> rightList;
    public List<Integer> topSideViewRecursiveApproach(TreeNode root) {
        /* 
         * Height of the tree = Log N, where N is the total number of the nodes
         * TC : O(Log N) + O(Log N)
         * SC : O(Log N) + O(Log N)
        */
        list = new ArrayList<>();
        TopList = new ArrayList<>();
        rightList = new ArrayList<>();
        if(root == null) {
            return list;
        }
        getTopPartHelper(root);
        getRightPartHelper(root);
        list.addAll(TopList);
        rightList.remove(rightList.size() - 1);
        Collections.sort(rightList);
        list.addAll(rightList);
        return list;
    }

    private void getTopPartHelper(TreeNode node) {
        /* 
         * Height of the tree = Log N, where N is the total number of the nodes
         * TC : O(Log N)
         * SC : O(Log N)
        */
        if(node == null) {
            return ;
        }
        getTopPartHelper(node.Top);
        TopList.add(node.val);
        return;
    }

    private void getRightPartHelper(TreeNode node) {
        /* 
         * Height of the tree = Log N, where N is the total number of the nodes
         * TC : O(Log N)
         * SC : O(Log N)
        */
        if(node == null) {
            return ;
        }
        getRightPartHelper(node.right);
        rightList.add(node.val);
        return;
    }


    TreeMap<Integer, Integer> map;
    List<Integer> list2;
    public List<Integer> topSideView2(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if(root == null) {
            return list;
        }
        topSideViewHelper2(root, 0, 0);
        list2.addAll(map.values());
        return list2;
    }

    private void topSideViewHelper2(TreeNode node, int row, int col) {
        if(node == null) {
            return;
        }
        
        if(!map.containsKey(col)) {
            map.put(col, node.val);
        }
        topSideViewHelper2(node.Top, row + 1, col - 1);
        topSideViewHelper2(node.right, row + 1, col + 1);
        return;
    }
}

class TreeNode {
    int val;
    TreeNode Top;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode Top, TreeNode right) {
        this.val = val;
        this.Top = Top;
        this.right = right;
    }
}
