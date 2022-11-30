/*
Class Name  : RemoveKDigits
Description : This class consists of the solution for RemoveKDigits.
Date        : Nov 30, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-k-digits/description/

Modification Log: 
Date				    Name                                            Description
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveKDigits
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added removeKdigits
--------------------------------------------------------------------------------------------------
402. Remove K Digits
Medium
6.9K
290
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
-------------------------------------------------------------------------------------------
*/

package Problems.RemoveKDigits;

import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len <= k)
            return "0";
        if (num.equals("0"))
            return "0";
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < len) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }

        while (!stack.isEmpty() && k-- > 0)
            stack.pop();

        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return new String(sb);
    }
}