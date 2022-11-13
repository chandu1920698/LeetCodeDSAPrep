/*
Class Name  : PalindromicSubstrings
Description : This class consists of the solution for PalindromicSubstrings.
Date        : Nov 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/palindromic-substrings/description/

Modification Log: 
Date				    Name                                            Description
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class PalindromicSubstrings 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added countSubstrings
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added countPalindromes
--------------------------------------------------------------------------------------------------
647. Palindromic Substrings
Medium
8.3K
179
Companies
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.PalindromicSubstrings;

public class PalindromicSubstrings {

    /*
     * TC : O(N^2)
     * Sc : O(1)
    */
    public int countSubstrings(String str) {
        if(str == null || str.length() < 1) return 0;
        int count = 0;
        for(int i=0;i<str.length();i++){
            count += countPalindromes(str, i, i); //Count even sized
            count += countPalindromes(str, i, i+1); //Count odd sized
        }
        return count;
    }
    
    private int countPalindromes(String str, int s, int e){
        int count = 0;
        while(s>=0 && e<str.length() && str.charAt(s) == str.charAt(e)){
            s--;
            e++;
            count++;
        }
        return count;
    }
}
