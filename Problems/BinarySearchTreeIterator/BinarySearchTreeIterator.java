/*
Class Name  : BinarySearchTreeIterator
Description : This class consists of the solution for BinarySearchTreeIterator.
Created Date: Mar 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-search-tree-iterator/description/
Modification Log: 
Date					    Name                                            Description
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added Class BinarySearchTreeIterator
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added pushAllLeftNodes 
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added next 
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added hasNext 
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added inOrderTraversal 
--------------------------------------------------------------------------------------------------
173. Binary Search Tree Iterator
Medium
7.3K
439
Companies
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

 

Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.
 

Follow up:

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
------------------------------------------------------------------------------------------------------
*/
package Problems.BinarySearchTreeIterator;

import java.util.*;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private List<Integer> inOrderList;

    public BinarySearchTreeIterator(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(H)
         * H - Height of the tree
        */
        stack = new Stack<>();
        pushAllLeftNodes(root);
    }

    private void pushAllLeftNodes(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(H)
        */
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        /* 
         * TC : O(1)
         * SC : O(1)
        */
        TreeNode node = stack.pop();
        pushAllLeftNodes(node.right);
        return node.val;
    }

    public boolean hasNext() {
        /* 
         * TC : O(1)
         * SC : O(1)
        */
        return !stack.isEmpty();
    }

    private void inOrderTraversal(TreeNode root) {
        /* 
         * This approach is not a better one
         * Brute Force
         * TC : O(N)
         * SC : O(N)
        */
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        this.inOrderList.add(root.val);
        inOrderTraversal(root.right);
        return;
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