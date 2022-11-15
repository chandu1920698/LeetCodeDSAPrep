/*
Class Name  : NumberOfSwapsToMakeStringBalanced
Description : This class consists of the solution for NumberOfSwapsToMakeStringBalanced.
Date        : Nov 15, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/

Modification Log: 
Date				    Name                                            Description
Nov 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class NumberOfSwapsToMakeStringBalanced 
Nov 15, 2022			Chandra Sekhar Reddy Muthumula					Added minSwaps
--------------------------------------------------------------------------------------------------
1963. Minimum Number of Swaps to Make the String Balanced
Medium
1.2K
42
Companies
You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

 

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.
 

Constraints:

n == s.length
2 <= n <= 106
n is even.
s[i] is either '[' or ']'.
The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
-------------------------------------------------------------------------------------------
*/
package Problems.MinimumNumberOfSwapsToMakeStringBalanced;

public class MinimumNumberOfSwapsToMakeStringBalanced {

    public static void main(String[] args) {
        
    }

    public int minSwaps(String s) {
        /*
        * TC : O(N)
        * SC : O(1)
        * We will be having equal number of open and closed brackets
        * Count every closed brackets and maintain its maximum value
        * For every swap with open bracket it reduces two closed brackets
        */
        
        int len = s.length();
        int closed_bracket_count = 0;
        int max_closed_bracket_count = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ']') max_closed_bracket_count = Math.max(++closed_bracket_count, max_closed_bracket_count);
            else closed_bracket_count--;
        }
        System.out.println("max_closed_bracket_count : " + max_closed_bracket_count);
        return (max_closed_bracket_count + 1) >> 1;
    }
}