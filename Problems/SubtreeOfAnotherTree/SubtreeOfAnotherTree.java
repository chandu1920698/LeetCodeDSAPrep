
/*
Class Name  : SubtreeOfAnotherTree
Description : This class consists of the solution for SubtreeOfAnotherTree.
Created Date: Jan 26, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/subtree-of-another-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class SubtreeOfAnotherTree
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added isSubtreeRecursiveApproach
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added isTreeIdentical
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added isSameIterativeApproach
Jan 26, 2022			Chandra Sekhar Reddy Muthumula					Added isSubtreeIterativeApproach
--------------------------------------------------------------------------------------------------
572. Subtree of Another Tree
Easy
6.8K
383
Companies
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
-------------------------------------------------------------------------------------------
*/
package Problems.SubtreeOfAnotherTree;
import java.util.*;
public class SubtreeOfAnotherTree {
    public boolean isSubtreeRecursiveApproach(TreeNode root, TreeNode subRoot) {
        /*
         * TC : O(N)
         * SC : O(N)
        */
        /* 
         * If the subTree is null, then it is always the subtree of any given tree
         * So return true
        */
        if(subRoot == null) {
            return true;
        }
        /* 
         * If the main tree is null, the no given tree is the sub tree 
         * So return false
        */
        if(root == null) {
            return false;
        }
        /* 
         * If the sub tree root and the main tree root, are not null
         * Then check if they are identical.
         * If identical return true
        */
        if(isTreeIdentical(root, subRoot)) {
            return true;
        }
        /* 
         * If they are not identical then check for the left and right nodes
        */
        return isSubtreeRecursiveApproach(root.left, subRoot) || isSubtreeRecursiveApproach(root.right, subRoot);
    }

    private boolean isTreeIdentical (TreeNode root1, TreeNode root2) {
        /* 
         * If the given roots are both null, then they are identical trees
         * So return true
        */
        if(root1 == null && root2 == null) {
            return true;
        }

        /* 
         * If both are  null, and their values are equal, then  check for the left and right nodes
         * If identical return true
         * else return false
        */ 
        if(root1 != null && root2 != null) {
            return (root1.val == root2.val) && isTreeIdentical(root1.left, root2.left) && isTreeIdentical(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public boolean isSubtreeIterativeApproach(TreeNode s, TreeNode t) {
       
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(s);
        
        while(!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            
            if(node.val == t.val && isSameIterativeApproach(node, t)){
               return true;
            }
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            
        }
        return false;
    }
    
    private boolean isSameIterativeApproach(TreeNode p, TreeNode q){
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        stack.push(p);
        stack.push(q);
        
        while(!stack.isEmpty()){
            
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            
            if(a == null && b == null) {
                continue;
            }
        
            if(a == null || b == null) {
                return false;
            }
            
            if(a.val != b.val){
                return false;
            }
            
            stack.push(a.left);
            stack.push(b.left);
            stack.push(a.right);
            stack.push(b.right);
        }
        
        return true;
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
