/*
Class Name  : SumofTwoIntegers
Description : This class consists of the solution for SumofTwoIntegers.
Date        : Sep 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sum-of-two-integers/
Modification Log: 
Date					Name                                            Description
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class SumofTwoIntegers 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added getSum 
--------------------------------------------------------------------------------------------------
371. Sum of Two Integers

Given two integers a and b, return the sum of the two integers without using the operators + and -.


Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000
------------------------------------------------------------------------------------------------------
*/

class SumofTwoIntegers {
    public int getSum(int a, int b) {
	
		/*
		TC 			: O(1)
		SC 			: O(1)
		Recommended : YES
		*/
		
        while( b != 0 ) {
            int carry = (a & b) << 1; // This carry variable stores the carry, which will be added in next iteration.
            a ^= b;
            b = carry;
        }
        return a;
    }
}