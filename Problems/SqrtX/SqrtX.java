/*
Class Name  : SqrtX
Description : This class consists of the solution for SqrtX.
Date        : Jun 07, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sqrtx/description/

Modification Log: 
Date					Name                                            Description
Jun 07, 2023			Chandra Sekhar Reddy Muthumula					Added class SqrtX 
Jun 07, 2023			Chandra Sekhar Reddy Muthumula					Added mySqrt 
--------------------------------------------------------------------------------------------------
69. Sqrt(x)
Easy
6.5K
4.1K
Companies
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.SqrtX;

public class SqrtX {
    public int mySqrt(int x) {
        /* 
         * TC : O(Log N)
         * SC : O(1)
        */
        int start = 1, end = x;
        int ans = 0;
        while(start <= end) {
            int mid = start + ((end - start) / 2);
            if(mid == x / mid) {
                return mid;
            } else if(mid < x / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}