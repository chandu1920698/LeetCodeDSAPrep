/*
Class Name  : RemoveAllAdjacentDuplicatesInString
Description : This class consists of the solution for RemoveAllAdjacentDuplicatesInString.
Date        : Nov 21, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

Modification Log: 
Date				    Name                                            Description
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveAllAdjacentDuplicatesInString 
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added removeDuplicatesOptimalWay
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added removeDuplicatesLessOptimalWay
--------------------------------------------------------------------------------------------------
1047. Remove All Adjacent Duplicates In String
Easy
5.1K
202
Companies
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.RemoveAllAdjacentDuplicatesInString;
import java.util.*;
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicatesOptimalWay(String s) {
        /*
         * TC : O(N)
         * SC : O(1) 
        */
        int len = s.length();
        if (len == 1) return s;
        StringBuffer resultString = new StringBuffer();
        for (int  i = 0; i < len; i++) {
            char c = s.charAt(i);
            int resultStringLen = resultString.length();
            if (resultStringLen > 0 && resultString.charAt(resultStringLen - 1) == c) resultString.deleteCharAt(resultStringLen - 1);
            else resultString.append(c);
        }
        return resultString.toString();
    }

    public String removeDuplicatesLessOptimalWay(String s) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N) 
        */
        int len = s.length();
        if (len == 1) return s;
        Stack<Character> charStack = new Stack<>();
        for (int  i = 0; i < len; i++) {
            if (!charStack.isEmpty() && charStack.peek() == s.charAt(i)) charStack.pop();
            else charStack.push(s.charAt(i));
        }

        StringBuffer resultString = new StringBuffer();
        while (!charStack.isEmpty()) {
            resultString.append(charStack.pop());
        }

        return new String(resultString.reverse());
    }
}