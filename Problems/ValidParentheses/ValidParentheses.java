/*
Class Name  : ValidParentheses
Description : This class consists of the solution for ValidParentheses.
Date        : Oct 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/

Modification Log: 
Date					Name                                            Description
Oct 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidParentheses 
Oct 13, 2022			Chandra Sekhar Reddy Muthumula					Added isValid
Jul 17, 2023			Chandra Sekhar Reddy Muthumula					Added isValidSecond
--------------------------------------------------------------------------------------------------
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
-------------------------------------------------------------------------------------------
*/
package Problems.ValidParentheses;
import java.util.*;;
public class ValidParentheses {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if ( stack.isEmpty() || stack.pop() != c) {
                return false;
            } 
        }
        
        return stack.isEmpty();
    }
    public boolean isValidSecond(String s) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < len; i++) {
            char currentBracket = s.charAt(i);
            if(currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                stack.push(currentBracket);
            } else if(stack.isEmpty() == false) {
                if(stack.peek() == '(' && ')' == currentBracket) {
                    stack.pop();
                } else if(stack.peek() == '[' && ']' == currentBracket) {
                    stack.pop();
                } else if(stack.peek() == '{' && '}' == currentBracket) {
                    stack.pop();
                } else {
                stack.push(currentBracket);
            }
            } else {
                stack.push(currentBracket);
            }
        }
        return stack.isEmpty();
    }
}