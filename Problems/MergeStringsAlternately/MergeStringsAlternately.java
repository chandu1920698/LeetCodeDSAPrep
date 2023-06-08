/*
Class Name  : MergeStringsAlternately
Description : This class consists of the solution for MergeStringsAlternately.
Date        : Jun 07, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/merge-strings-alternately/description/

Modification Log: 
Date					Name                                            Description
Jun 07, 2023			Chandra Sekhar Reddy Muthumula					Added class MergeStringsAlternately 
Jun 07, 2023			Chandra Sekhar Reddy Muthumula					Added mySqrt 
--------------------------------------------------------------------------------------------------
1768. Merge Strings Alternately
Easy
2.2K
40
Companies
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.MergeStringsAlternately;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int len = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(i = 0; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(i < word1.length()) {
            sb.append(word1.substring(i, word1.length()));
        } else if(i < word2.length()) {
            sb.append(word2.substring(i, word2.length()));
        }

        return new String(sb);
    }
}