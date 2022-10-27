/*
Class Name  : FindIndexOfTheFirstOccurrenceString
Description : This class consists of the solution for FindIndexOfTheFirstOccurrenceString.
Date        : Oct 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

Modification Log: 
Date					Name                                            Description
Oct 27, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindIndexOfTheFirstOccurrenceString 
Oct 27, 2022			Chandra Sekhar Reddy Muthumula					Added FindIndexOfTheFirstOccurrenceString
--------------------------------------------------------------------------------------------------
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, 
return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
-------------------------------------------------------------------------------------------
*/
package Problems.FindIndexOfTheFirstOccurrenceString;

public class FindIndexOfTheFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        
        // This is an edge case, if the length of the needle is greater than the 
        // length of the haystack then return -1 as needle will never fit into haystack
        if(nlen > hlen) return -1;
        
        // For every sub string of the haystack equal to the length of the needle
        // Check if it is equal to the needle
        // If yes return the index i
        for (int i = 0; i + nlen <= hlen; i++) {
            if(haystack.substring(i, i + nlen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}