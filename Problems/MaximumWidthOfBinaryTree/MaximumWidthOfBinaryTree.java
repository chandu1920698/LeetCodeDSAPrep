/*
Class Name  : MaximumWidthOfBinaryTree
Description : This class consists of the solution for MaximumWidthOfBinaryTree.
Created Date: Jan 28, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaximumWidthOfBinaryTree
Jan 28, 2022			Chandra Sekhar Reddy Muthumula					Added widthOfBinaryTree
--------------------------------------------------------------------------------------------------
662. Maximum Width of Binary Tree
Medium
6.2K
853
Companies
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100

-------------------------------------------------------------------------------------------
*/

package Problems.MaximumWidthOfBinaryTree;
import java.util.*;
public class MaximumWidthOfBinaryTree {
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        if(root == null) {
            return ans;
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offerLast(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int toSubtract = queue.peekLast().num;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.peekLast().node;
                int currIndex = queue.peekLast().num - toSubtract;
                queue.pollLast();
                if(i == 0) {
                    first = currIndex;
                }
                if(i == size - 1) {
                    last = currIndex;
                }
                if(node.left != null) {
                    queue.offerFirst(new Pair(node.left, 2 * currIndex + 1));
                }
                if(node.right != null) {
                    queue.offerFirst(new Pair(node.right, 2 * currIndex + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}

class Pair {
    Pair() {

    }
    
    TreeNode node;
    int num;
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
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
