/*
Class Name  : EvaluateReversePolishNotation
Description : This class consists of the solution for EvaluateReversePolishNotation.
Date        : Nov 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

Modification Log: 
Date				    Name                                            Description
Nov 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class EvaluateReversePolishNotation
Nov 24, 2022			Chandra Sekhar Reddy Muthumula					Added evalRPN
--------------------------------------------------------------------------------------------------
150. Evaluate Reverse Polish Notation
Medium
4.3K
747
Companies
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
-------------------------------------------------------------------------------------------
*/
package Problems.EvaluateReversePolishNotation;

import java.util.*;

public class EvaluateReversePolishNotation {
    /*
     * TC : O(N)
     * SC : O(N)
     * Stack Implementation
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (tokens[i].equals("-"))
                stack.push(-stack.pop() + stack.pop());
            else if (tokens[i].equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (tokens[i].equals("/")) {
                int secondOperand = stack.pop();
                stack.push(stack.pop() / secondOperand);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}