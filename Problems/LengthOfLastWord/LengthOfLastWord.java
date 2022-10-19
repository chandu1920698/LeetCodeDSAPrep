/*
Class Name  : LengthOfLastWord
Description : This class consists of the solution for LengthOfLastWord.
Date        : Oct 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/length-of-last-word/

Modification Log: 
Date					Name                                            Description
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class LengthOfLastWord 
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLastWord
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLastWordSimple
--------------------------------------------------------------------------------------------------
58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
-------------------------------------------------------------------------------------------
*/
package Problems.LengthOfLastWord;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Using the Java inbuild methods
        String[] str = s.trim().split(" ");
        int len = str.length;
        return str[len - 1].length();
    }
    
    public int lengthOfLastWordSimple(String s) {
        // Normal approach
        int lastIndex = s.length() - 1;
        if(lastIndex == 0) return 1;
        while(lastIndex >= 0 && s.charAt(lastIndex) == ' ')lastIndex--;
        
        int index = lastIndex;
        
        while(index >= 0 && s.charAt(index) != ' ')index--;
        return lastIndex - index;
    }
}   