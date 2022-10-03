/*
Class Name  : HappyNumber
Description : This class consists of the solution for HappyNumber.
Date        : Oct 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/happy-number/
Modification Log: 
Date				Name                                            Description
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class HappyNumber 
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added isHappy 
--------------------------------------------------------------------------------------------------
202. Happy Number

Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Example 2:
Input: n = 2
Output: false

Constraints:

1 <= n <= 2^31 - 1
------------------------------------------------------------------------------------------------------
*/
package Problems.HappyNumber;

public class HappyNumber {
    public boolean isHappy(int n) {
        
        // This is Recursive Method
        /*
        * TC : O(LogN)
        * SC : O(LogN)
        */
        return helper(n) == 1 ? true : false;
        
        
        // This is a Iterative method
        /*
        * TC : O(LogN)
        * SC : O(1)
        */
        // Did not getany idea how to solve it in Iterations
        
    }
    
    public int helper(int squareSum) {
        if (Math.pow(squareSum, 2) < 10 || squareSum == 4) {
            return squareSum;
        } else {
            int tempSquareSum = 0;
            while(squareSum > 0) {
                tempSquareSum += Math.pow(squareSum%10, 2);
                squareSum /= 10;
            }
            return helper(tempSquareSum);
        }
    }
}