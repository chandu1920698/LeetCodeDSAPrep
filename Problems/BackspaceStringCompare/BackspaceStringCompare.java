/*
Class Name  : BackspaceStringCompare
Description : This class consists of the solution for BackspaceStringCompare.
Date        : Nov 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/backspace-string-compare/description/

Modification Log: 
Date				    Name                                            Description
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class BackspaceStringCompare
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added backspaceCompare
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added updateStringBuilder
--------------------------------------------------------------------------------------------------
844. Backspace String Compare
Easy
5.8K
265
Companies
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?
-------------------------------------------------------------------------------------------
*/
package Problems.BackspaceStringCompare;

public class BackspaceStringCompare {
    
    public boolean backspaceCompare(String s, String t) {
        /*
         * TC : O(Max(M, N))
         * SC : O(1)
        */
        int sLength = s.length();
        int tLength = t.length();
        StringBuilder sFinal = new StringBuilder();
        StringBuilder tFinal = new StringBuilder();
        int sIndex = 0, tIndex = 0;
        while(sIndex < sLength && tIndex < tLength) {
            sFinal = updateStringBuilder(sFinal, sIndex++, s);
            tFinal = updateStringBuilder(tFinal, tIndex++, t);
        }
        while(sIndex < sLength ) {
            sFinal = updateStringBuilder(sFinal, sIndex++, s);
        }
        while( tIndex < tLength) {
            tFinal = updateStringBuilder(tFinal, tIndex++, t);
        }
        // System.out.println("sFinal : " + sFinal + " tFinal : " + tFinal);
        return new String(tFinal).equals(new String(sFinal));
    }

    public StringBuilder updateStringBuilder(StringBuilder finalString, int index, String s) {
        if (index < s.length()) {
            char currentChar = s.charAt(index);
            int finalLength = finalString.length();
            if (finalLength > 0 && currentChar == '#') {
                finalString.deleteCharAt(finalLength - 1);
            } else {
                if (currentChar != '#') finalString.append(currentChar);
            }
        }
        return finalString;
    }
}