/*
Class Name  : UglyNumber2
Description : This class consists of the solution for UglyNumber2.
Created Date: Mar 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/ugly-number-ii/description/
Modification Log: 
Date					    Name                                            Description
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added Class UglyNumber2
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added nthUglyNumber 
--------------------------------------------------------------------------------------------------
264. Ugly Number II
Medium
5.2K
254
Companies
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690
------------------------------------------------------------------------------------------------------
*/
package Problems.UglyNumber2;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for(int i = 1; i < n; i++) {
            int twoMultiple = dp[p2] * 2;
            int threeMultiple = dp[p3] * 3;
            int fiveMultiple = dp[p5] * 5;

            dp[i] = Math.min(twoMultiple, Math.min(threeMultiple, fiveMultiple));
            if(dp[i] == twoMultiple) {
                p2++;
            }
            if(dp[i] == threeMultiple) {
                p3++;
            }
            if(dp[i] == fiveMultiple) {
                p5++;
            }
        } 
        return dp[n - 1];  
    }
}