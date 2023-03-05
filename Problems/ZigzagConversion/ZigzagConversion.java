/*
Class Name  : ZigzagConversion
Description : This class consists of the solution for ZigzagConversion.
Created Date: Mar 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/zigzag-conversion/description/
Modification Log: 
Date					    Name                                            Description
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added Class ZigzagConversion
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added convert 
--------------------------------------------------------------------------------------------------
6. Zigzag Conversion
Medium
5.9K
11.8K
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
------------------------------------------------------------------------------------------------------
*/
package Problems.ZigzagConversion;

public class ZigzagConversion {
    public String convert(String s, int row) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        if (row == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            int j = i;
            if (i == 0 || i == row - 1) {
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * (row - 1);
                }
            } else {
                boolean diagonal = false;
                while (j < s.length()) {
                    if (!diagonal) {
                        sb.append(s.charAt(j));
                        j += 2 * (row - i - 1);
                        diagonal = true;
                    } else {
                        sb.append(s.charAt(j));
                        j += 2 * i;
                        diagonal = false;
                    }
                }
            }
        }
        return sb.toString();
    }
}