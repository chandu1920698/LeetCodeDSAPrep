/*
Class Name  : MinCostClimbingStairs
Description : This class consists of the solution for MinCostClimbingStairs.
Created Date: Dec 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/min-cost-climbing-stairs/description/

Modification Log: 
Date					Name                                            Description
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinCostClimbingStairs 
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added minCostClimbingStairsRecursion 
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added minCost 
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added minCostClimbingStairsTopDown 
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added minCostClimbingStairsBottomUp 
Dec 27, 2022			Chandra Sekhar Reddy Muthumula					Added minCostClimbingStairsBestApproach 
--------------------------------------------------------------------------------------------------
746. Min Cost Climbing Stairs
Easy
8.5K
1.3K
Companies
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
-------------------------------------------------------------------------------------------
*/
package Problems.MinCostClimbingStairs;

public class MinCostClimbingStairs {
    public int minCostClimbingStairsRecursion(int[] cost) {
        /* 
         * Recursive Approach
         * TC : O(2 ^ N) {Best and Worst case}
         * SC : O(1)
        */
        int len = cost.length;
        return Math.min(minCost(cost, len - 1), minCost(cost, len - 2));
    }

    public int minCost(int[] cost, int n) {
        if(n < 0) {
            // If index is out of the bounds return 0
            return 0;
        }

        if(n == 1 || n == 0) {
            return cost[n];
        }

        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    public static int[] dp;
    public int minCostClimbingStairsTopDown(int[] cost) {
        /* 
         * Recursive + Memiozation
         * TC : O(2 ^ N)
         * SC : O(N)
        */
        int len = cost.length;
        dp = new int[len];
        return Math.min(minCost(cost, len - 1), minCost(cost, len - 2));
    }

    public int minCostClimbingStairsBottomUp(int[] cost) {
        /* 
         * Bottom Down Approach
         * TC : O(N)
         * SC : O(N)
        */
        int len = cost.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if(i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[len - 1], dp[len - 2]); 
    }

    public int minCostClimbingStairsBestApproach(int[] cost) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int len = cost.length;
        if(len <= 2) {
            return Math.min(cost[0], cost[1]);
        }
        int first = cost[0], second = cost[1];
        for (int i = 2; i < len; i++) {
           int curr = cost[i] + Math.min(first, second);
           first = second;
           second = curr;
        }
        return Math.min(first, second); 
    }
}