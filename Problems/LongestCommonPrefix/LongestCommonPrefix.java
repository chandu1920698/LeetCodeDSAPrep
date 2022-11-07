/*
Class Name  : LongestCommonPrefix
Description : This class consists of the solution for LongestCommonPrefix.
Date        : Nov 6, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/longest-common-prefix/

Modification Log: 
Date				Name                                            Description
Nov 6, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestCommonPrefix 
Nov 6, 2022			Chandra Sekhar Reddy Muthumula					Added longestCommonPrefix 
--------------------------------------------------------------------------------------------------
14. Longest Common Prefix
Easy
11.2K
3.5K
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.LongestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        
    }
    public String longestCommonPrefix(String[] strs) {
        String common_string = strs[0];
        int len = strs.length;
        for (int i = 1; i < len;  i++) {
            if (strs[i] == "") {
                return "";
            }

            if (common_string.length() > strs[i].length()) {
                common_string = common_string.substring(0, strs[i].length());
            }

            if (common_string.equals(strs[i].substring(0, common_string.length()))) {
                continue;
            }
            while(!common_string.equals(strs[i].substring(0, common_string.length()))) {
                common_string = common_string.substring(0, common_string.length() - 1);
            }     
        }
        return common_string;
    }
}