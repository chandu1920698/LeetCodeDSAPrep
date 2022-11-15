/*
Class Name  : LongestRepeatingCharacterReplacement
Description : This class consists of the solution for LongestRepeatingCharacterReplacement.
Date        : Nov 15, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/longest-repeating-character-replacement/description/

Modification Log: 
Date				    Name                                            Description
Nov 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestRepeatingCharacterReplacement 
Nov 15, 2022			Chandra Sekhar Reddy Muthumula					Added characterReplacement
--------------------------------------------------------------------------------------------------
424. Longest Repeating Character Replacement
Medium
6.7K
260
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
-------------------------------------------------------------------------------------------
*/
package Problems.LongestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        /*
         * TC : O(N)
         * SC : O(1)
         */
        int len = s.length();
        int[] count_array = new int[26];
        int left = 0;
        int right;
        int max_window = 0;
        int max_freq = 0;
        for (right = 0; right < len; right++) {
            count_array[s.charAt(right) - 'A']++;
            for (int i = 0; i < 26; i++) {
                max_freq = Math.max(max_freq, count_array[i]);
            }
            while (right - left + 1 - max_freq > k) {
                count_array[s.charAt(left) - 'A']--;
                left++;
            }
            max_window = Math.max(max_window, right - left + 1);
        }
        return max_window;
    }
}