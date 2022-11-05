/*
Class Name  : IsSubsequence
Description : This class consists of the solution for IsSubsequence.
Date        : Nov 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/is-subsequence/description/

Modification Log: 
Date				Name                                            Description
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class IsSubsequence 
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added isSubsequence 
--------------------------------------------------------------------------------------------------
392. Is Subsequence
Easy
6.2K
346
Companies
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
-------------------------------------------------------------------------------------------
*/
package Problems.IsSubsequence;

public class IsSubsequence {
    
    public static void main(String[] args) {
        
    }

    public boolean isSubsequence(String s, String t) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        // If the length of s is less then t then return false
        int s_len = s.length();
        int t_len = t.length();
        if (s_len == 0) return true; 
        if (s_len > t_len) {return false;}

        int pointer_s = 0;
        int pointer_t = 0;

        while (pointer_t < t_len) {
            if (s.charAt(pointer_s) == t.charAt(pointer_t)) {
                pointer_s++;
            } 
            pointer_t++;
            if (pointer_s == s_len) return true;
        }
        return false;
    }
}