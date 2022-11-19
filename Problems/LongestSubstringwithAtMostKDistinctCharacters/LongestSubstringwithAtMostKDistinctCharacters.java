/*
Class Name  : LongestSubstringwithAtMostKDistinctCharacters
Description : This class consists of the solution for LongestSubstringwithAtMostKDistinctCharacters.
Date        : Nov 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://www.lintcode.com/problem/386/description

Modification Log: 
Date				    Name                                            Description
Nov 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestSubstringwithAtMostKDistinctCharacters 
Nov 19, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLongestSubstringKDistinct
--------------------------------------------------------------------------------------------------
386 · Longest Substring with At Most K Distinct Characters

Description
Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang0607)



Example 1:
Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"

Example 2:
Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"

Challenge
O(n) time
-------------------------------------------------------------------------------------------
*/
package Problems.LongestSubstringwithAtMostKDistinctCharacters;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here

        /*
         * TC : O(N)
         * SC : O(256) => O(1)
        */
        int[] freq = new int[256];
        int left = 0, right = 0, len = s.length(), unique_chars = 0;;
        int ans = 0;
        while (right < len) {
            if (freq[s.charAt(right++)]++ == 0) {
                unique_chars++;

                while(unique_chars > k) {
                    if(--freq[s.charAt(left++)] == 0) {
                        unique_chars--;
                    }
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}