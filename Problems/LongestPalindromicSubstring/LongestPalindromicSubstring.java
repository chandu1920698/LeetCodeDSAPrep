/*
Class Name  : LongestPalindromicSubstring
Description : This class consists of the solution for LongestCommonPrefix.
Date        : Nov 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/longest-palindromic-substring/description/

Modification Log: 
Date				Name                                            Description
Nov 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestPalindromicSubstring 
Nov 8, 2022			Chandra Sekhar Reddy Muthumula					Added longestPalindrome 
--------------------------------------------------------------------------------------------------
5. Longest Palindromic Substring
Medium
22.4K
1.3K
Companies
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String max_palindrome = "";
        int max_len = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // This is for odd palindrome
            int start = i, end = i;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 > max_len) {
                    max_len = end - start + 1;
                    max_palindrome = s.substring(start, end + 1);
                }
                start--;
                end++;
            }

            start = i;
            end = i + 1;
            while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 > max_len) {
                    max_len = end - start + 1;
                    max_palindrome = s.substring(start, end + 1);
                }
                start--;
                end++;
            }
        }
        return max_palindrome;
    }
}