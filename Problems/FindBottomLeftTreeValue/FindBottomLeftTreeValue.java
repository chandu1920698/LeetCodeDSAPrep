/*
Class Name  : FindBottomLeftTreeValue
Description : This class consists of the solution for FindBottomLeftTreeValue.
Created Date: Jan 30, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-bottom-left-tree-value/description/

Modification Log: 
Date				    Name                                            Description
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindBottomLeftTreeValue
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added findBottomLeftValueFirstApproach
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added findBottomLeftValueFirstApproachHelper
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added findBottomLeftValueSecondApproach
Jan 30, 2022			Chandra Sekhar Reddy Muthumula					Added findBottomLeftValueSecondApproachHelper
--------------------------------------------------------------------------------------------------
513. Find Bottom Left Tree Value
Medium
2.7K
235
Companies
Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.FindBottomLeftTreeValue;

public class FindBottomLeftTreeValue {
    int ans;
    int maxDepth;

    public int findBottomLeftValueFirstApproach(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if (root == null) {
            return 0;
        }
        maxDepth = 1;
        ans = root.val;
        findBottomLeftValueFirstApproachHelper(root, 1);
        return ans;
    }

    private void findBottomLeftValueFirstApproachHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }
        findBottomLeftValueFirstApproachHelper(root.left, depth + 1);
        findBottomLeftValueFirstApproachHelper(root.right, depth + 1);
        return;
    }

    int bottomLeftValue;
    int maxRow;
    int minCol;

    public int findBottomLeftValueSecondApproach(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        if (root == null) {
            return 0;
        }
        maxRow = 0;
        minCol = 0;
        bottomLeftValue = root.val;

        findBottomLeftValueSecondApproachHelper(root, 0, 0);
        return bottomLeftValue;
    }

    private void findBottomLeftValueSecondApproachHelper(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        if (maxRow < row) {
            maxRow = Math.max(maxRow, row);
            bottomLeftValue = root.val;
            if (minCol > col) {
                minCol = Math.min(minCol, col);
                bottomLeftValue = root.val;
            }
        }
        findBottomLeftValueSecondApproachHelper(root.left, row + 1, col - 1);
        findBottomLeftValueSecondApproachHelper(root.right, row + 1, col + 1);
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