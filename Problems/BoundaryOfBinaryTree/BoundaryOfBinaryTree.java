/*
Class Name  : BoundaryOfBinaryTree
Description : This class consists of the solution for BoundaryOfBinaryTree.
Created Date: Jan 19, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/878/

Modification Log: 
Date				    Name                                            Description
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class BoundaryOfBinaryTree
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added boundaryOfBinaryTree
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added getLeftBoundary
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added getRightBoundary
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added getLeafNodes
Jan 19, 2022			Chandra Sekhar Reddy Muthumula					Added isLeaf
--------------------------------------------------------------------------------------------------
878 · Boundary of Binary Tree


Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. 
Right boundary is defined as the path from root to the right-most node. 
If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary.
 Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree 
if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang1104)


Example
Example 1:

Input: {1,#,2,3,4}
Output: [1,3,4,2]
Explanation: 
  1
   \
    2
   / \
  3   4
  The root doesn't have left subtree, so the root itself is left boundary.
  The leaves are node 3 and 4.
  The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
  So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2:

Input: {1,2,3,4,5,6,#,#,#,7,8,9,10}
Output: [1,2,4,7,8,9,10,6,3]
Explanation: 
          1
     /          \
    2            3
   / \          / 
  4   5        6   
     / \      / \
    7   8    9  10  
  The left boundary are node 1,2,4. (4 is the left-most node according to definition)
  The leaves are node 4,7,8,9,10.
  The right boundary are node 1,3,6,10. (10 is the right-most node).
  So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
-------------------------------------------------------------------------------------------
*/
package Problems.BoundaryOfBinaryTree;


import java.util.*;

public class BoundaryOfBinaryTree {
    List<Integer> ans;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        ans = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        if(isLeaf(root) == false) ans.add(root.val);
        getLeftBoundary(root);
        getLeafNodes(root);
        getRightBoundary(root);
        return ans;
    }

    private void getLeftBoundary(TreeNode root) {
        TreeNode currNode = root.left;
        while(currNode != null) {
            if(isLeaf(currNode) == false) {
                ans.add(currNode.val);
            }
            if(currNode.left != null) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        // System.out.println("Left : " + ans);
    }
    private void getRightBoundary(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        TreeNode curr = root.right;
        while(curr != null) {
            if(isLeaf(curr) == false) {
                stack.push(curr.val);
            }
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        // System.out.println("Stack : " + stack);
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }
    private void getLeafNodes(TreeNode root) {
        if(isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        if(root.left != null) {
            getLeafNodes(root.left);
        }
        if(root.right != null) {
            getLeafNodes(root.right);
        }
    }
    private boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
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