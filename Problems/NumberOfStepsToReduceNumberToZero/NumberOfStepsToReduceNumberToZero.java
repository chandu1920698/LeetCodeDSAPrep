
/*
Class Name  : NumberOfStepsToReduceNumberToZero
Description : This class consists of the solution for NumberOfStepsToReduceNumberToZero.
Date        : Oct 2, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
Modification Log: 
Date					Name                                            Description
Oct 2, 2022			Chandra Sekhar Reddy Muthumula					Added Class NumberOfStepsToReduceNumberToZero 
Oct 2, 2022			Chandra Sekhar Reddy Muthumula					Added numberOfSteps 
--------------------------------------------------------------------------------------------------
1342. Number of Steps to Reduce a Number to Zero

Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.


Example 1:
Input: num = 14
Output: 6
Explanation: 
Step 1) 14 is even; divide by 2 and obtain 7. 
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3. 
Step 4) 3 is odd; subtract 1 and obtain 2. 
Step 5) 2 is even; divide by 2 and obtain 1. 
Step 6) 1 is odd; subtract 1 and obtain 0.

Example 2:
Input: num = 8
Output: 4
Explanation: 
Step 1) 8 is even; divide by 2 and obtain 4. 
Step 2) 4 is even; divide by 2 and obtain 2. 
Step 3) 2 is even; divide by 2 and obtain 1. 
Step 4) 1 is odd; subtract 1 and obtain 0.
Example 3:

Input: num = 123
Output: 12
 
Constraints:

0 <= num <= 106
------------------------------------------------------------------------------------------------------
*/
package Problems.NumberOfStepsToReduceNumberToZero;

public class NumberOfStepsToReduceNumberToZero {
    public int numberOfSteps(int num) {
        // This is using recursion
        /*
        * TC : O(LogN)
        * SC : O(LogN)
        */
        // return numberOfStepsRecursion(num, 0);
        
        // This is using normal iteration
         /*
        * TC : O(LogN)
        * SC : O(1)
        */
        int count = 0;
        while(num >0 ) {
            if(num > 0) {
                if ((num & 1) == 1) { // num is odd
                    num--;
                } else { // num is even
                    num >>>= 1;
                }
                count++;
            }
        }
        return count;
    }
    
    public int numberOfStepsRecursion(int num, int count) {
        if(num > 0) {
            if ((num & 1) == 1) { // num is odd
                return numberOfStepsRecursion(num - 1, ++count);
            } else { // num is even
                return numberOfStepsRecursion(num/2, ++count);
            }
        }
        return count;
    }
}