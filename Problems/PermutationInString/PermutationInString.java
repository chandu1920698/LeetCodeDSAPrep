/*
Class Name  : PermutationInString
Description : This class consists of the solution for PermutationInString.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/permutation-in-string/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class PermutationInString 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added checkInclusion
--------------------------------------------------------------------------------------------------
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.PermutationInString;
import java.util.*;
public class PermutationInString {
    public static void main(String[] args) {
        
    }
    public static boolean checkInclusion(String s1, String s2) {
        
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if (lenS1 > lenS2) {
            return false;
        }
        int[] s1Counter = new int[26];
        int[] s2Counter = new int[26];
        
        for (int i = 0; i < lenS1; i++) {
            s1Counter[s1.charAt(i) - 'a']++;
            s2Counter[s2.charAt(i) - 'a']++;
        }
        
        int start = 0;
        int end = lenS1;
        
        if (Arrays.equals(s1Counter, s2Counter )) {
            return true;
        } else {
            while(end < lenS2) {
                
                // Discard the last element from the counterS2
                s2Counter[s2.charAt(start++) - 'a']--;
                
                // Add the next element to the counterS2
                s2Counter[s2.charAt(end++) - 'a']++;
                
                if (Arrays.equals(s1Counter, s2Counter )) return true;
            }
        }  
        return false;
    }
}