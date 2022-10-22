/*
Class Name  : RepeatedDNASequences
Description : This class consists of the solution for RepeatedDNASequences.
Date        : Oct 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/repeated-dna-sequences/

Modification Log: 
Date					Name                                            Description
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class RepeatedDNASequences 
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added findRepeatedDnaSequences
--------------------------------------------------------------------------------------------------
187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences
(substrings) that occur more than once in a DNA molecule. You may return the answer in any order.


Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
-------------------------------------------------------------------------------------------
*/
package Problems.RepeatedDNASequences;

import java.util.*;;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedSubsequenses = new ArrayList<>();

        HashMap<String, Integer> seen = new HashMap<>();

        int i = 0;
        int len = s.length();
        while (i + 10 <= len) {
            String subsequence = s.substring(i, i + 10);
            seen.put(subsequence, seen.getOrDefault(subsequence, 0) + 1);

            if (seen.get(subsequence) == 2) {
                repeatedSubsequenses.add(subsequence);
            }
            i++;
        }
        return repeatedSubsequenses;
    }
}