/*
Class Name  : ClimbingStairs
Description : This class consists of the solution for ClimbingStairs.
Created Date: Dec 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/climbing-stairs/description/

Modification Log: 
Date					Name                                            Description
Dec 25, 2022			Chandra Sekhar Reddy Muthumula					Added Class ClimbingStairs 
Dec 25, 2022			Chandra Sekhar Reddy Muthumula					Added climbStairs 
--------------------------------------------------------------------------------------------------
70. Climbing Stairs
Easy
16.4K
494
Companies
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
-------------------------------------------------------------------------------------------
*/
package Problems.ClimbingStairs;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // This is my first DP leet code problem

        /* 
        * There are four steps to solve any DP in the world.
        * Step 1: Indetify -> Search for the key words like Maximum, Minimum, Longest, Largest, Count
        *                     Total, No Of permutations, etc.
        * Step 2: Decide the state expression -> State(N) : Always mentioned in the question
        *         State (K) : Replace N with K.
        * Step 3: Formulate a state Relation - Imp
        *       ->  How does the current state result is reelated to the previous state result
        *       -> State(K) = State(k- 1) + State(K - 2);
        * Step 4: Optimization - Tabulation/Memoization
        *       -> Higher Order Dynamic Programming => 2-D and above
        */

        /* Approach */
        /*
        * Step 1: Identify
        * This is identified as we need to find the distinct ways to climb to the top of the stairs
        */
        
        /*
        * Step 2: Decide the state expression
        * State (K) : Replace N with K.
        */

        /*
        * Step 3: Formulate a state Relation - Imp
        * Eg: State(4) = State(3) + State(2)
        */

        /*
        * Step 4: This is not required as it is a 1-D dynamic programming problem
        */

        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("Array : " + Arrays.toString(dp));
        return dp[n];
    }   
}