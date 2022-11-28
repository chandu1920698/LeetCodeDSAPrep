/*
Class Name  : GenerateParentheses
Description : This class consists of the solution for GenerateParentheses.
Date        : Nov 28, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/generate-parentheses/description/

Modification Log: 
Date				    Name                                            Description
Nov 28, 2022			Chandra Sekhar Reddy Muthumula					Added Class GenerateParentheses
Nov 28, 2022			Chandra Sekhar Reddy Muthumula					Added generateParenthesis
Nov 28, 2022			Chandra Sekhar Reddy Muthumula					Added backtracking
--------------------------------------------------------------------------------------------------
22. Generate Parentheses
Medium
16.1K
625
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
-------------------------------------------------------------------------------------------
*/

package Problems.GenerateParentheses;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list, "", 0, 0, n);
        return list;

    }

    public void backtracking(List<String> list, String currentString, int open, int close, int max) {
        if (currentString.length() == max * 2) {
            list.add(currentString);
            return;
        }

        if (open < max)
            backtracking(list, currentString + "(", open + 1, close, max);
        if (close < open)
            backtracking(list, currentString + ")", open, close + 1, max);
    }
}