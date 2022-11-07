/*
Class Name  : LongestSubstringWithoutRepeatingCharacters
Description : This class consists of the solution for LongestCommonPrefix.
Date        : Nov 7, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Modification Log: 
Date				Name                                            Description
Nov 7, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestSubstringWithoutRepeatingCharacters 
Nov 7, 2022			Chandra Sekhar Reddy Muthumula					Added longestCommonPrefix 
--------------------------------------------------------------------------------------------------
3. Longest Substring Without Repeating Characters
Medium
30.1K
1.3K
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
-------------------------------------------------------------------------------------------
*/
package Problems.LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * Intuition
     * We can solve this problem with the sliding window approach.
     * 
     * Approach
     * We use aet set to track if the character is a duplicate or not.
     * If the cahracter is not a duplicate in set, then increase the size of the
     * window. Else decrease the size of the window from the left side till there is
     * no duplaite in the set, by removing the characters in the set.
     * 
     * Complexity
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        int s_len = s.length();
        if (s_len == 0)
            return 0;

        Set<String> freq = new HashSet<>();
        int max_count = 0;
        int window_start = 0;
        for (int i = 0; i < s_len; i++) {
            while (!freq.add(s.substring(i, i + 1))) {
                freq.remove(s.substring(window_start, window_start + 1));
                window_start++;
            }
            freq.add(s.substring(i, i + 1));
            max_count = Math.max(max_count, i + 1 - window_start);
        }
        return max_count;
    }
}