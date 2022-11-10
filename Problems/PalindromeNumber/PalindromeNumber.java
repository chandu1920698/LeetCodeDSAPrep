/*
Class Name  : PalindromeNumber
Description : This class consists of the solution for PalindromeNumber.
Date        : Nov 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/palindrome-number/description/

Modification Log: 
Date				Name                                            Description
Nov 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class PalindromeNumber 
Nov 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class isPalindromeNumbers 
Nov 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class isPalindromeString 
--------------------------------------------------------------------------------------------------
9. Palindrome Number
Easy
7.8K
2.4K
Companies
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
-------------------------------------------------------------------------------------------
*/
package Problems.PalindromeNumber;

import java.util.*;

public class PalindromeNumber {

    public boolean isPalindromeNumbers(int x) {
        if (x < 0)
            return false;
        int num = x;
        int result = 0;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result == num ? true : false;
    }

    public boolean isPalindromeString(int x) {
        String s = Integer.valueOf(x).toString();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}