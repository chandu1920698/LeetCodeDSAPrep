/*
Class Name  : UniqueLength3PalindromicSubsequences
Description : This class consists of the solution for UniqueLength3PalindromicSubsequences.
Date        : Nov 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/

Modification Log: 
Date				    Name                                            Description
Nov 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class UniqueLength3PalindromicSubsequences 
Nov 18, 2022			Chandra Sekhar Reddy Muthumula					Added countPalindromicSubsequence
Nov 18, 2022			Chandra Sekhar Reddy Muthumula					Added isNumeric
--------------------------------------------------------------------------------------------------
1930. Unique Length-3 Palindromic Subsequences
Medium
533
16
Companies
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.UniqueLength3PalindromicSubsequences;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        /*
         * TC : O(26 * N)
         * SC : O(1)
        */
        int len = s.length();
        int[] first_occurrence = new int[26];
        int[] last_occurrence = new int[26];

        for (int i = 0; i < 26; i++) {
            first_occurrence[i] = -1;
            last_occurrence[i] = -1;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (first_occurrence[index] == -1) first_occurrence[index] = i;
            last_occurrence[index] = i;
        }

        boolean[] visited;
        int ans = 0, count = 0;
        for (int i = 0; i < 26; i++) {
            int first = first_occurrence[i];
            int last = last_occurrence[i];
            visited = new boolean[26];
            count = 0;
            for (int j = first + 1; j < last; j++) {
                int index = s.charAt(j) - 'a';
                if(!visited[index]) {
                    count++;
                    visited[index] = true;
                }
            }
            ans += count;
        }
        return ans;
    }
}