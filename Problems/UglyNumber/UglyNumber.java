/*
Class Name  : UglyNumber
Description : This class consists of the solution for UglyNumber.
Date        : Nov 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/ugly-number/description/

Modification Log: 
Date				    Name                                            Description
Nov 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class UglyNumber 
Nov 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class isUgly 
--------------------------------------------------------------------------------------------------
263. Ugly Number
Easy
1.8K
1.2K
Companies
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 

Constraints:

-231 <= n <= 231 - 1

-------------------------------------------------------------------------------------------
*/
package Problems.UglyNumber;

public class UglyNumber {
    
    public boolean isUgly(int n) {
        for (int i = 2; i < 6 && n > 0; i++) {
            while(n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}