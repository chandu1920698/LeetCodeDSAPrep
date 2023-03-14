/*
Class Name  : MaximumProductOftheLengthOfTwoPalindromicSubsequences
Description : This class consists of the solution for MaximumProductOftheLengthOfTwoPalindromicSubsequences.
Created Date: Mar 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/
Modification Log: 
Date					    Name                                            Description
Mar 14, 2022			    Chandra Sekhar Reddy Muthumula					Added Class MaximumProductOftheLengthOfTwoPalindromicSubsequences
Mar 14, 2022			    Chandra Sekhar Reddy Muthumula					Added maxProduct 
Mar 14, 2022			    Chandra Sekhar Reddy Muthumula					Added isPalindrome 
--------------------------------------------------------------------------------------------------
2002. Maximum Product of the Length of Two Palindromic Subsequences
Medium
677
45
Companies
Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. The two subsequences are disjoint if they do not both pick a character at the same index.

Return the maximum possible product of the lengths of the two palindromic subsequences.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.

 

Example 1:

example-1
Input: s = "leetcodecom"
Output: 9
Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
The product of their lengths is: 3 * 3 = 9.
Example 2:

Input: s = "bb"
Output: 1
Explanation: An optimal solution is to choose "b" (the first character) for the 1st subsequence and "b" (the second character) for the 2nd subsequence.
The product of their lengths is: 1 * 1 = 1.
Example 3:

Input: s = "accbcaxxcxx"
Output: 25
Explanation: An optimal solution is to choose "accca" for the 1st subsequence and "xxcxx" for the 2nd subsequence.
The product of their lengths is: 5 * 5 = 25.
 

Constraints:

2 <= s.length <= 12
s consists of lowercase English letters only.
------------------------------------------------------------------------------------------------------
*/
package Problems.MaximumProductOftheLengthOfTwoPalindromicSubsequences;
import java.util.*;
public class MaximumProductOftheLengthOfTwoPalindromicSubsequences {
    /* 
     * TC : O(2 ^ N)
     * SC : O(2 ^ N)
    */
    public int maxProduct(String s) {
        int product = 0;
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < (1 << n); i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    sb.append(s.charAt(n - 1 - j));
                }
            }

            if(isPalindrome(new String(sb))) {
                map.put(i, sb.length());
            }
        }
        for(Integer i : map.keySet()) {
            for(Integer j : map.keySet()) {
                if(i != j && (i & j) == 0) {
                    product = Math.max(product, map.get(i) * map.get(j));
                }
            }
        }

        return product;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}