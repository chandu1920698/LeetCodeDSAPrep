/*
Class Name  : LongestSubstringwithAtMostTwoDistinctCharacters
Description : This class consists of the solution for LongestSubstringwithAtMostTwoDistinctCharacters.
Date        : Nov 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://www.lintcode.com/problem/928/description

Modification Log: 
Date				    Name                                            Description
Nov 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestSubstringwithAtMostTwoDistinctCharacters 
Nov 19, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLongestSubstringKDistinct
Nov 19, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLongestSubstringTwoDistinctRestrictiveApproach
--------------------------------------------------------------------------------------------------
928 · Longest Substring with At Most Two Distinct Characters

Description
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang0607)

Example 1
Input: “eceba”
Output: 3
Explanation:
T is "ece" which its length is 3.

Example 2
Input: “aaa”
Output: 3
-------------------------------------------------------------------------------------------
*/
package Problems.LongestSubstringwithAtMostTwoDistinctCharacters;
import java.util.*;;
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinctBestApproach(String s) {
        // Write your code here
        /*
         * TC : O(N)
         * SC : O(256)
        */
        int[] freq = new int[256];
        int left = 0, right = 0, len = s.length(), unique_chars = 0;;
        int ans = 0;
        int k = 2;
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

    public int lengthOfLongestSubstringTwoDistinctRestrictiveApproach(String s) {
        // Write your code here
        int len = s.length();
        if (len <=2 ) return len;
        Set<String> set = new HashSet<String>();
        int left = 0;
        int max_count = 1;
        for (int i = 0; i < len; i++) {
            set.add(s.substring(i, i + 1));
            if (set.size() <= 2) {
                max_count = Math.max(max_count, i - left + 1);
            } else {
                while (left < i) {
                    if (set.contains(s.substring(left, left + 1))) {
                        set.remove(s.substring(left, left + 1));
                    }
                    left++;
                }
                left--;
                set.add(s.substring(left, left + 1));
                char left_char = s.charAt(left);
                while (left - 1 >= 0 && s.charAt(left - 1) == left_char) left--;
                max_count = Math.max(max_count, i - left + 1);
            }
        }
    return max_count;
    }
}