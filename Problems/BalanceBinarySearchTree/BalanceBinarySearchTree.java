/*
Class Name  : BalanceBinarySearchTree
Description : This class consists of the solution for BalanceBinarySearchTree.
Created Date: Jan 23, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/balance-a-binary-search-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class BalanceBinarySearchTree
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added balancedBST
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added balanceBST
Jan 23, 2022			Chandra Sekhar Reddy Muthumula					Added inorderTraversal
--------------------------------------------------------------------------------------------------
1382. Balance a Binary Search Tree
Medium
2.4K
61
Companies


Given the root of a binary search tree, return a balanced binary search tree with the same node values. 
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.BalanceBinarySearchTree;
import java.util.*;
public class BalanceBinarySearchTree {
    List<TreeNode> inOrdeTraversalArray = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return balancedBST(inOrdeTraversalArray, 0, inOrdeTraversalArray.size() - 1);
    }

    private TreeNode balancedBST(List<TreeNode> array, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode node = array.get(mid);
        node.left = balancedBST(array, start, mid - 1);
        node.right = balancedBST(array, mid + 1, end);
        return node;
    }

    private void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        inOrdeTraversalArray.add(root);
        inorderTraversal(root.right);
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
