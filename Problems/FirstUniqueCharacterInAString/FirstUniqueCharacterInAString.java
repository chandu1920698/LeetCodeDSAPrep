/*
Class Name  : FirstUniqueCharacterInAString
Description : This class consists of the solution for FirstUniqueCharacterInAString.
Date        : Nov 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/first-unique-character-in-a-string/description/

Modification Log: 
Date				Name                                            Description
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class FirstUniqueCharacterInAString 
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added firstUniqChar
--------------------------------------------------------------------------------------------------
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. 
If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.FirstUniqueCharacterInAString;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        
    }

    public static int firstUniqChar(String s) {
        int[] s_freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s_freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s_freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}