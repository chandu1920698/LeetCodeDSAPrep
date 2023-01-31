/*
Class Name  : VerticalOrderTraversalOfBinaryTree
Description : This class consists of the solution for VerticalOrderTraversalOfBinaryTree.
Created Date: Jan 31, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class VerticalOrderTraversalOfBinaryTree
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added VerticalOrderTraversalOfBinaryTree
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added verticalTraversalHelper
--------------------------------------------------------------------------------------------------
987. Vertical Order Traversal of a Binary Tree
Hard
5.7K
4K
Companies
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) 
and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings 
for each column index starting from the leftmost column and ending on the rightmost column. 
There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/

package Problems.VerticalOrderTraversalOfBinaryTree;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    Map<Integer, Map<Integer, List<Integer>>> columnValuesMap;
    List<List<Integer>> lists;
    int row;
    int col;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /* 
         * TC : O(N) + O(N)
         * SC : O(N) + O(N)
        */
        columnValuesMap = new TreeMap<>();
        lists = new ArrayList<>();
        row = 0;
        col = 0;
        verticalTraversalHelper(root, 0, 0);
        for (Integer key : columnValuesMap.keySet()) {
            Map<Integer, List<Integer>> tempMap = columnValuesMap.get(key);
            List<Integer> rowList = new ArrayList<>();
            for (Integer tempKey : tempMap.keySet()) {
                List<Integer> tempRowList = tempMap.get(tempKey);
                Collections.sort(tempRowList);
                rowList.addAll(tempRowList);
            }
            // System.out.println(rowList);
            lists.add(rowList);
        }
        return lists;
    }

    private void verticalTraversalHelper(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        if (!columnValuesMap.containsKey(col)) {
            columnValuesMap.put(col, new TreeMap<>());
        }
        if (!columnValuesMap.get(col).containsKey(row)) {
            columnValuesMap.get(col).put(row, new ArrayList<>());
        }
        columnValuesMap.get(col).get(row).add(root.val);
        // System.out.println(columnValuesMap);
        verticalTraversalHelper(root.left, row + 1, col - 1);
        verticalTraversalHelper(root.right, row + 1, col + 1);
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