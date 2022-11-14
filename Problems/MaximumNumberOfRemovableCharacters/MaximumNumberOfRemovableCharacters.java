/*
Class Name  : MaximumNumberOfRemovableCharacters
Description : This class consists of the solution for MaximumNumberOfRemovableCharacters.
Date        : Nov 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/maximum-number-of-removable-characters/description/

Modification Log: 
Date				    Name                                            Description
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaximumNumberOfRemovableCharacters 
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added maximumRemovalsinarySearchApproach
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added isSubsequence
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added maximumRemovalsRecursive
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added recursionHelper
--------------------------------------------------------------------------------------------------
1898. Maximum Number of Removable Characters
Medium
723
81
Companies
You are given two strings s and p where p is a subsequence of s. 
You are also given a distinct 0-indexed integer array removable containing a subset of indices of s (s is also 0-indexed).

You want to choose an integer k (0 <= k <= removable.length) such that, 
after removing k characters from s using the first k indices in removable, 
p is still a subsequence of s. More formally, you will mark the character at s[removable[i]] for each 0 <= i < k, 
then remove all marked characters and check if p is still a subsequence.

Return the maximum k you can choose such that p is still a subsequence of s after the removals.

A subsequence of a string is a new string generated from the original string
 with some characters (can be none) deleted without changing the relative order of the remaining characters.

 

Example 1:

Input: s = "abcacb", p = "ab", removable = [3,1,0]
Output: 2
Explanation: After removing the characters at indices 3 and 1, "abcacb" becomes "accb".
"ab" is a subsequence of "accb".
If we remove the characters at indices 3, 1, and 0, "abcacb" becomes "ccb", and "ab" is no longer a subsequence.
Hence, the maximum k is 2.
Example 2:

Input: s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
Output: 1
Explanation: After removing the character at index 3, "abcbddddd" becomes "abcddddd".
"abcd" is a subsequence of "abcddddd".
Example 3:

Input: s = "abcab", p = "abc", removable = [0,1,2,3,4]
Output: 0
Explanation: If you remove the first index in the array removable, "abc" is no longer a subsequence.
 

Constraints:

1 <= p.length <= s.length <= 105
0 <= removable.length < s.length
0 <= removable[i] < s.length
p is a subsequence of s.
s and p both consist of lowercase English letters.
The elements in removable are distinct.
-------------------------------------------------------------------------------------------
*/
package Problems.MaximumNumberOfRemovableCharacters;

import java.util.*;

public class MaximumNumberOfRemovableCharacters {
    public int maximumRemovalsinarySearchApproach(String s, String p, int[] removable) {
        /*
         * TC : O(N LogK)
         * SC : O(N)
         */
        int start = 0;
        int end = removable.length;
        char[] letters = s.toCharArray();
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            for (int i = 0; i < mid; i++)
                letters[removable[i]] = '/';
            if (isSubsequence(letters, p)) {
                start = mid + 1;
            } else {
                for (int i = 0; i < mid; i++)
                    letters[removable[i]] = s.charAt(removable[i]);
                end = mid - 1;
            }
        }
        return end;
    }

    public boolean isSubsequence(char[] list, String p) {
        int pointerS = 0;
        int pointerP = 0;
        int slen = list.length;
        int plen = p.length();
        for (pointerS = 0; pointerS < slen; pointerS++) {

            if (list[pointerS] == p.charAt(pointerP)) {
                pointerP++;
            }
            if (pointerP == plen) {
                return true;
            }
        }

        return false;
    }

    public int maximumRemovalsRecursive(String s, String p, int[] removable) {
        // This will give you time TLE
        /*
         * TC : O(N * K)
         * SC : O(N)
        */
        int slen = s.length();
        int plen = p.length();
        List<Character> list = new ArrayList<Character>();
        if (plen > slen)
            return 0;
        for (int i = 0; i < slen; i++) {
            list.add(s.charAt(i));
        }
        return recursionHelper(list, p, removable, 0);

    }

    public int recursionHelper(List<Character> list, String p, int[] removable, int index) {

        if (index == removable.length) {
            return 0;
        }
        int count = 0;
        int max_count = 0;
        for (int i = index; i < removable.length; i++) {
            Character c = list.get(removable[i]);
            list.set(removable[i], ' ');
            // System.out.println("list : " + list + " Count: " + (count));
            // if (isSubsequence(list, p)) {
            // count = 1 + recursionApproach(list, p, removable, i + 1);
            // max_count = Math.max(max_count, count);
            // } else {
            // break;
            // }
            // list.set(removable[i], c);
            // recursionApproach(list, p, removable, i + 1, count);

        }
        return max_count;
    }
}