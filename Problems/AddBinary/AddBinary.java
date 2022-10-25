/*
Class Name  : AddBinary
Description : This class consists of the solution for AddBinary.
Date        : Oct 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/add-binary/

Modification Log: 
Date					Name                                            Description
Oct 25, 2022			Chandra Sekhar Reddy Muthumula					Added Class AddBinary 
Oct 25, 2022			Chandra Sekhar Reddy Muthumula					Added addBinary
--------------------------------------------------------------------------------------------------
67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
-------------------------------------------------------------------------------------------
*/
package Problems.AddBinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        /*
         * TC : O(Max Length (a, b))
         * SC : O(1)
        */
        int alen = a.length();
        int blen = b.length();
        String result = "";
        
        int len = Math.max(alen, blen);
        int carry = 0;
        for(int i = 0; i < len; i++) {
            int aDigit = i < alen ? a.charAt(alen - 1 - i) - '0' : 0;
            int bDigit = i < blen ? b.charAt(blen - 1 - i) - '0' : 0;
            
            int total = aDigit + bDigit + carry;
            result = total % 2 + result;
            carry = total / 2;
            
        }
        if(carry == 1) result = carry + result; 
        return result;
    }
}