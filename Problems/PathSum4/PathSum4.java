/*
Class Name  : PathSum4
Description : This class consists of the solution for PathSum4.
Created Date: Jan 31, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.codingninjas.com/codestudio/problem-details/path-sum-iv_1229382

Modification Log: 
Date				    Name                                            Description
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class PathSum4
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added pathSum
Jan 31, 2022			Chandra Sekhar Reddy Muthumula					Added pathSumHelper
--------------------------------------------------------------------------------------------------
Path Sum IV
Posted: 6 Mar, 2021
Difficulty: Moderate

PROBLEM STATEMENT

You are given an array 'A' of length 'N' consisting of three-digit integers in ascending order. 
You can construct a binary tree from these integers. 
All integers are of form DPV (3 digits), where 'D' tells depth in the tree, 'P' tells position in the tree, and 'V' tells value in this position.


For Example:

215 means value 5 is in position 1 at depth 2.
Your task in the problem is to find the sum of all paths from node to leaf.

Note:

The maximum depth allowed is 4, i.e. the maximum number of positions can be 8 ( or 2 ^ (4 - 1)).
Input Format:
The first line of the input contains ‘T’ denoting the number of test cases.

The first line of each test case contains an integer ‘N’, representing the length of the array.

The second line of each test case contains N space-separated integers of the array A. 
Output Format:
For each test case print a single line containing a single integer denoting the sum of all paths from the root node.

The output of each test case is printed on a new line.
Constraints:
1 <= T <= 10
1 <= N <= 150
100 <= A[i] <= 999 
1 <= D <= 4
1 <= P <= 8
0 <= V <= 9

Where ‘T’ denotes the number of test cases and 'N' denotes the length of array 'A'.

Time limit: 1 sec.
APPROACH 1
Explanation:

Here we solve the problem assuming we have been given a normal tree. We traverse it by keeping a root to leaf running(or prefix) sum. 
If we see a leaf node, we add the running sum to the final result.
Now each tree node is represented by a number. 1st digit is the level, 2nd is the position in that level,
 3rd digit is the value. We need to find a way to traverse this tree and get the sum.
To move left of the current node we increase the depth by 1. And make position p to 2*p-1.
To move right of the current node we increase the depth by 1. And make position p to 2*p.
 

Algorithm:

From the first two digits of the integer given, we can determine the position of the value (the last digit) in the binary tree.
Initially, we can hash/map the position with value, and traverse through the binary tree as if it were a complete binary tree. 
We also maintain the prefix sum from the root node to leaf while traversing.
From each position, we check if we can move to left and right of the node. If we can’t move in either direction 
it means the current node is the leaf node. And we return the prefix sum till now.
If we can move in either direction we move thereafter adding the current node value in the prefix sum till now.
-------------------------------------------------------------------------------------------
*/

package Problems.PathSum4;
import java.util.*;
public class PathSum4 {
    static int ans;
    static Map<Integer, Integer> mp;
    public static int pathSum(int[] a, int n) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        ans = 0;
        mp = new HashMap<>(a.length);
        for (int num : a) {
            mp.put(num / 10, num % 10);
        }
        pathSumHelper(11, 0);
        return ans;
    }

   public static void pathSumHelper(int node, int t) {
        if (!mp.containsKey(node)) {
            return;
        }
        t += mp.get(node);
        int d = node / 10, p = node % 10;
        int l = (d + 1) * 10 + (p * 2) - 1;
        int r = l + 1;
        if (!mp.containsKey(l) && !mp.containsKey(r)) {
            ans += t;
            return;
        }
        pathSumHelper(l, t);
        pathSumHelper(r, t);
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