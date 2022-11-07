/*
Class Name  : IsomorphicStrings
Description : This class consists of the solution for LongestCommonPrefix.
Date        : Nov 7, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/isomorphic-strings/description/

Modification Log: 
Date				Name                                            Description
Nov 7, 2022			Chandra Sekhar Reddy Muthumula					Added Class IsomorphicStrings 
Nov 7, 2022			Chandra Sekhar Reddy Muthumula					Added isIsomorphic 
--------------------------------------------------------------------------------------------------
205. Isomorphic Strings
Easy
5.3K
997
Companies
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
-------------------------------------------------------------------------------------------
*/
package Problems.IsomorphicStrings;

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        // HashSet<Character> set = new HashSet<>();
        int s_len = s.length();
        if (s_len != t.length())
            return false;

        for (int i = 0; i < s_len; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                if (!map.values().contains(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}