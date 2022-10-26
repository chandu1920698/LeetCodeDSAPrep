/*
Class Name  : FindAllAnagramsInAString
Description : This class consists of the solution for FindAllAnagramsInAString.
Date        : Oct 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

Modification Log: 
Date					Name                                            Description
Oct 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindAllAnagramsInAString 
Oct 26, 2022			Chandra Sekhar Reddy Muthumula					Added findAnagramsBruteForce
Oct 26, 2022			Chandra Sekhar Reddy Muthumula					Added findAnagramsEfficient
--------------------------------------------------------------------------------------------------
438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.FindAllAnagramsInAString;
import java.util.*;
public class FindAllAnagramsInAString {
    public List<Integer> findAnagramsBruteForce(String s, String p) {

        /* Brute Force
         * N - s.length()
         * M - p.length()
         * TC : O(MLogM) + O(N)*(O(M) + O(M))
         * SC : O(M) + O(N)*O(M)
        */

        int sLen = s.length();
        int pLen = p.length();
        List<Integer> list = new ArrayList<>();
        
        if(pLen > sLen) {
            return list;
        }
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        
        for (int i = 0; i + pLen <= sLen; i++) {
            char[] temp = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(temp);
            
            int j = 0;
            for (; j < pLen; j++) {
                if(temp[j] != pChar[j]) {
                    break;
                }
            }
            if (j == pLen) list.add(i);
        }
        return list;
    }

    public List<Integer> findAnagramsEfficient(String s, String p) {
        /* Sliding Window Method
         * N - s.length()
         * M - p.length()
         * TC : O(N*52)
         * SC : O(52)
        */
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> list = new ArrayList<>();
        
        if(pLen > sLen) {
            return list;
        }
        
        int[] sChar = new int[26];
        int[] pChar = new int[26];
        
        for (int i = 0; i < pLen; i++) {
            sChar[s.charAt(i) - 'a']++;
            pChar[p.charAt(i) - 'a']++;
        }
        
        int left = 0, right = pLen;
        
        while(right < sLen) {
            if(Arrays.equals(sChar, pChar)) list.add(left);
            
            // Add the element to the right
            sChar[s.charAt(right++) - 'a']++;
            // Discard the element to the left
            sChar[s.charAt(left++) - 'a']--;
        }        
        if(Arrays.equals(sChar, pChar)) list.add(left);
        return list;
    }
}