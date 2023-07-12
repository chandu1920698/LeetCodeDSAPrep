/*
Class Name  : MaximumNumberofVowelsinSubstringofGivenLength
Description : This class consists of the solution for MaximumNumberofVowelsinSubstringofGivenLength.
Date        : Jul 12, 2023
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

Modification Log: 
Date				    Name                                            Description
Jul 12, 2023			Chandra Sekhar Reddy Muthumula					Added Class MaximumNumberofVowelsinSubstringofGivenLength 
Jul 12, 2023			Chandra Sekhar Reddy Muthumula					Added maxVowels
Jul 12, 2023			Chandra Sekhar Reddy Muthumula					Added isVowel
--------------------------------------------------------------------------------------------------
1456. Maximum Number of Vowels in a Substring of Given Length
Medium
2.8K
97
Companies
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

-------------------------------------------------------------------------------------------
*/
package Problems.MaximumNumberofVowelsinSubstringofGivenLength;

public class MaximumNumberofVowelsinSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        int len = s.length();
        if (k > len) {
            k = len;
        }
        if (k == 1) {
            for (int i = 0; i < len; i++) {
                if (isVowel(s.charAt(i))) {
                    return 1;
                }
            }
        }

        int start = 0, end = k - 1;
        int vCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vCount++;
            }
        }
        int maxVCount = vCount;

        while (start < end && end < len - 1) {
            if (isVowel(s.charAt(++end))) {
                vCount++;
            }
            if (isVowel(s.charAt(start++))) {
                vCount--;
            }
            maxVCount = Math.max(maxVCount, vCount);
        }
        return maxVCount;

    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}