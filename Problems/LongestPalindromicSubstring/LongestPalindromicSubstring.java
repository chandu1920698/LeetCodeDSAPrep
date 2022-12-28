/*
Class Name  : LongestPalindromicSubstring
Description : This class consists of the solution for LongestCommonPrefix.
Created Date: Nov 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/longest-palindromic-substring/description/

Modification Log: 
Date				Name                                            Description
Nov 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestPalindromicSubstring 
Nov 8, 2022			Chandra Sekhar Reddy Muthumula					Added longestPalindrome 
Dec 28, 2022		 Sekhar Reddy Muthumula					        Added longestPalindromeBruteForce 
Dec 28, 2022		Chandra Sekhar Reddy Muthumula					Added isPalindrome 
Dec 28, 2022		Chandra Sekhar Reddy Muthumula					Added longestPalindromeBestApproach
Dec 28, 2022		Chandra Sekhar Reddy Muthumula					Added maxLength
--------------------------------------------------------------------------------------------------
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.


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

    public String longestPalindromeBruteForce(String s) {
        /* 
         * TC : O(N ^ 3)
         * SC : O(1)
        */
        int max_len = 0;
        String maxPalidrome = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                if(isPalindrome(s.substring(i, j))) {
                    if(max_len < j - i) {
                        max_len = j  - i;
                        maxPalidrome = s.substring(i, j);
                    }
                }
            }
        }
        return maxPalidrome;
    }

    public boolean isPalindrome(String str) {
        int len = str.length();
        if(len == 1) {
            return true;
        }
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindromeBestApproach(String s) {
        /* 
         * TC : O(N ^ 2)
         * SC : O(N)
        */
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = maxLength(s, i, i);
            int len2 = maxLength(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if(maxLen > end - start) {
                start = i - ((maxLen - 1) / 2);
                end = i + (maxLen / 2);
            }

        }
        return s.substring(start, end + 1);
    }

    public int maxLength(String str, int left, int right) {
        if(str == null || right < left) {
            return 0;
        }
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}