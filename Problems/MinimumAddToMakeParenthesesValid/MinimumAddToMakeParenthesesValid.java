/*
Class Name  : MinimumAddToMakeParenthesesValid
Description : This class consists of the solution for MinimumAddToMakeParenthesesValid.
Date        : Nov 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

Modification Log: 
Date				    Name                                            Description
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumAddToMakeParenthesesValid
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added minAddToMakeValidBestApproach
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added minAddToMakeValid
--------------------------------------------------------------------------------------------------
921. Minimum Add to Make Parentheses Valid
Medium
3.1K
166
Companies
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
-------------------------------------------------------------------------------------------
*/
package Problems.MinimumAddToMakeParenthesesValid;

import java.util.*;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValidBestApproach(String s) {

        /*
         * TC : O(N)
         * SC : O(1)
         * This is the best method
         */
        int len = s.length();
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        int open = 0, closed = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                ++closed;
            else if (ch == ')' && closed > 0) {
                --closed;
            } else {
                ++open;
            }
        }
        return open + closed;
    }

    public int minAddToMakeValid(String s) {
        /*
         * TC : O(N)
         * SC : O(N)
         * This is a stack based approach
         */
        int len = s.length();
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        int closed = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                ++closed;
            }
        }
        return stack.size() + closed;
    }
}