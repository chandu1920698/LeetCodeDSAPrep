/*
Class Name  : RangeSumOfBST
Description : This class consists of the solution for RangeSumOfBST.
Created Date: Jan 22, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/range-sum-of-bst/description/

Modification Log: 
Date				    Name                                            Description
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class RangeSumOfBST
Jan 22, 2022			Chandra Sekhar Reddy Muthumula					Added rangeSumBST
--------------------------------------------------------------------------------------------------
938. Range Sum of BST
Easy
5.6K
353
Companies
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

 

Example 1:


Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
Example 2:


Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
-------------------------------------------------------------------------------------------
*/
package Problems.RangeSumOfBST;

public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        /* 
         * TC : O(Log N)
         * SC : O(N)
        */
        if(root == null) {
            return 0;
        } else if(root.val <= high && root.val >= low) {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        } else if(root.val > high || root.val < low) {
            if(root.val > high) {
                rangeSumBST(root.left, low, high);
            } else if(root.val < low) {
                rangeSumBST(root.right, low, high);
            }
        }
        return sum;
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
