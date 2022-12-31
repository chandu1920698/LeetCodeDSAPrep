/*
Class Name  : NthTribonacciNumber
Description : This class consists of the solution for NthTribonacciNumber.
Created Date: Dec 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/n-th-tribonacci-number/description/

Modification Log: 
Date					Name                                            Description
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class NthTribonacciNumber 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added tribonacciBotttomUpApproach 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added tribonacciTopDownApproach 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added helper 
--------------------------------------------------------------------------------------------------
1137. N-th Tribonacci Number
Easy
2.5K
133
Companies
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
-------------------------------------------------------------------------------------------
*/
package Problems.NthTribonacciNumber;

public class NthTribonacciNumber {

    public int tribonacciBotttomUpApproach(int n) {
        
        int[] dp = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        
        return dp[n];
    }

    static int[] dp;
    public int tribonacciTopDownApproach(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        if(dp[n] != 0) {
            return dp[n];
        }
        return helper(n);
    }

    public int helper(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(n - 1) + helper(n - 2) + helper(n - 3);
        return dp[n];
    }
}