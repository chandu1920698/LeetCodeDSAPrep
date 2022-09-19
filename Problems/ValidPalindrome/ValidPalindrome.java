/*
Class Name  : ValidPalindrome
Description : This class consists of the solution for ValidPalindrome.
Date        : Sep 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/valid-palindrome/
Modification Log: 
Date					Name                                            Description
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class isPalindrome 
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added merge
--------------------------------------------------------------------------------------------------
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
------------------------------------------------------------------------------------------------------
*/
class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        //s = s.replace(" ","");
        // -> The method is not possible 
        // int stringLength = s.length();
        // char[] charArray = s.toCharArray();
        // for (int i=0; i<stringLength; i++) {
        //     short [] result = isALphaNumeric(charArray[i]);
        //     if (result[0] == 1) {
        //         charArray[i] = (char) result[1];
        //     } else {
        //         charArray[i] = '\u0000';
        //     }
        // }
        
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        // s = s.toLowerCase().replaceAll("[^\\dA-Za-z]", "");
        System.out.println(s);
        int start = 0;
        int end = s.length()-1;
        while(start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
    
    public short [] isALphaNumeric(char ch) {
        short asciiValue = (short) ch;
        if ((asciiValue <= 57 && asciiValue >= 48) ||(asciiValue <= 122 && asciiValue >= 97) )  {
            return new short [] {1, asciiValue};
        } else if  ((asciiValue <= 90 && asciiValue >= 65)) {
            return new short [] {1, (short) (asciiValue+32)};
        }
        return new short[]  {-1,-1};
    }
}