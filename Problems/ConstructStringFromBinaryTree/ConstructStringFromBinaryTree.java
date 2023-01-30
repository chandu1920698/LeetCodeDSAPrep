/*
Class Name  : ConstructStringFromBinaryTree
Description : This class consists of the solution for ConstructStringFromBinaryTree.
Created Date: Jan 30, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/construct-string-from-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class ConstructStringFromBinaryTree
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added tree2str
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added tree2strHelper
--------------------------------------------------------------------------------------------------
606. Construct String from Binary Tree
Easy
2.5K
3K
Companies
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree 
with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

 

Example 1:


Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)"
Example 2:


Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, 
except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-1000 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.ConstructStringFromBinaryTree;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        String treeString = tree2strHelper(root);
        return treeString;
    }

    private String tree2strHelper(TreeNode root) {
        if(root == null) {
            return "";
        }
        String left = tree2strHelper(root.left);
        String right = tree2strHelper(root.right);
        if(left.equals("") && !right.equals("")) {
            return root.val + "()" + "(" + right + ")";
        } else if(!left.equals("") && right.equals("")) {
            return root.val + "("+ left + ")";
        } else if(left.equals("") && right.equals("")) {
            return root.val + "";
        }else {
            return root.val + "(" + left + ")" + "(" + right + ")";
        }
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}