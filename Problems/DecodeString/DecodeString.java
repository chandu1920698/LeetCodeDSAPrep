/*
Class Name  : DecodeString
Description : This class consists of the solution for DecodeString.
Date        : Nov 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/decode-string/description/

Modification Log: 
Date				    Name                                            Description
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class DecodeString
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added decodeString
--------------------------------------------------------------------------------------------------
394. Decode String
Medium
9.8K
434
Companies
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
-------------------------------------------------------------------------------------------
*/
package Problems.DecodeString;
import java.util.*;
public class DecodeString {

    public String decodeStringBestApproach(String s) {
        /*
         * Best Approach
         * TC : O(N)
         * SC : O(N)
        */
        int len = s.length();
        if(len == 0) return s;
        Stack<String> result = new Stack<>();
        String finalString = "";
        for (int i = 0;  i < len; i++) {
            if (s.charAt(i) != ']') result.push(s.substring(i, i + 1));
            else {
                String temp = "";
                while (!result.isEmpty() && !result.peek().equals("[")) {
                    temp = result.pop() + temp;
                }
                result.pop();
                int count = 0;
                int product = 1;
                while (!result.isEmpty() && Character.isDigit(result.peek().toCharArray()[0])) {
                    count = product * (result.pop().toCharArray()[0] - '0') + count;
                    product *= 10;
                }
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    res.append(temp);
                }
                result.push(res.toString());
            }
        }
        while (!result.isEmpty()) {
            finalString = result.pop() + finalString;
        }
        return finalString;
    }


    public String decodeString(String s) {
         /*
         * Best Approach
         * TC : O(N)
         * SC : O(N) + O(N)
        */
        int len = s.length();
        if(len == 0) return s;
        Stack<String> result = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        String res = "";
        int index = 0;
        while (index < len) {
            char currentChar = s.charAt(index);
            if (Character.isDigit(s.charAt(index))) {
                int freq = 0;
                while (Character.isDigit(s.charAt(index))){
                    freq = freq * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(freq);
            } else if (currentChar == '[') {
                result.push(res);
                res = "";
                index++;
            } else if (currentChar == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                res += currentChar;
                index++;
            }
        }
        return res;
    }   
}