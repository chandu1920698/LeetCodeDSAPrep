/*
Class Name  : SerializeAndDeserializeBinaryTree
Description : This class consists of the solution for SerializeAndDeserializeBinaryTree.
Created Date: Jan 29, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Modification Log: 
Date				    Name                                            Description
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added Class SerializeAndDeserializeBinaryTree
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added serialize
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added deserialize
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added serializeHelper
Jan 29, 2022			Chandra Sekhar Reddy Muthumula					Added deserializeHelper
--------------------------------------------------------------------------------------------------
297. Serialize and Deserialize Binary Tree
Hard
8.4K
305
Companies
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
-------------------------------------------------------------------------------------------
*/

package Problems.SerializeAndDeserializeBinaryTree;
import java.util.*;
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        return serializeHelper(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private String serializeHelper(TreeNode root) {
        if(root == null) {
            return "X,";
        }
        String left = serializeHelper(root.left);
        String right = serializeHelper(root.right);
        return root.val + "," + left + right;
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String nodeValue = queue.poll();
        if(nodeValue.equals("X")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(nodeValue));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
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