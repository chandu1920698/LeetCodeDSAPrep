/*
Class Name  : ValidPalindromeII
Description : This class consists of the solution for ValidPalindromeII.
Date        : Nov 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/valid-palindrome-ii/description/

Modification Log: 
Date				    Name                                            Description
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidPalindromeII 
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class validPalindromeBruteForce 
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class isPalindrome
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class validPalindromeBetterApproach 
--------------------------------------------------------------------------------------------------
680. Valid Palindrome II
Easy
6.5K
336
Companies
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.ValidPalindromeII;

public class ValidPalindromeII {
    
    public boolean validPalindromeBruteForce(String s) {
        int len = s.length();
        if (len == 1) return true;
        for (int i = 0; i < len; i++) {
            if (isPalindrome(s.substring(0, i) + s.substring(i + 1, len))) return true; 
        }
        return false;
    }

    public boolean validPalindromeBetterApproach(String s) {
        int len = s.length();
        if (len == 1) return true;
        int start = 0;
        int end = s.length() - 1;
        int removed = 0;
        while(start <= end) {
            if ( removed == 0 && s.charAt(start) != s.charAt(end)) {
                
                if (isPalindrome(s.substring(start + 1, end + 1))) {
                    removed++;
                    start++;
                } else if (isPalindrome(s.substring(start, end ))){
                    removed++;
                    end--;
                } else {
                    return false;
                }

            } else if (removed == 1 && s.charAt(start) != s.charAt(end)) {
                return false;
            } else if (removed == 2) {
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}