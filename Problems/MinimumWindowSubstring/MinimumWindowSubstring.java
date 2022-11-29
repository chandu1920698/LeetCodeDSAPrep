/*
Class Name  : MinimumWindowSubstring
Description : This class consists of the solution for MinimumWindowSubstring.
Date        : Nov 29, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/minimum-window-substring/description/

Modification Log: 
Date				    Name                                            Description
Nov 29, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumWindowSubstring
Nov 29, 2022			Chandra Sekhar Reddy Muthumula					Added minWindow
--------------------------------------------------------------------------------------------------
76. Minimum Window Substring
Hard
13.8K
602
Companies
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?


-------------------------------------------------------------------------------------------
*/

package Problems.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(tLen > sLen) return "";
        if(s.equals(t)) return t;
        Map<Character, Integer> tMap = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int minWindow = sLen + 1, count = 0, minLeft = 0, minRight = 0;
        while (right < sLen && left <= right) {
            char currentChar = s.charAt(right++);
            if (tMap.containsKey(currentChar)) {
                tMap.put(currentChar, tMap.get(currentChar) - 1);
                if(tMap.get(currentChar) >= 0) count++;
            }
            
            while (count == tLen) {
                if(minWindow > right - left) {
                    minWindow = right - left;
                    minLeft = left;
                    minRight = right;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    tMap.put(s.charAt(left), tMap.get(s.charAt(left)) + 1);
                    if(tMap.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return s.substring(minLeft, minRight);
    }
}