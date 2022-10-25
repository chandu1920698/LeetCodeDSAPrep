/*
Class Name  : MultiplyStrings
Description : This class consists of the solution for MultiplyStrings.
Date        : Oct 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/multiply-strings/

Modification Log: 
Date					Name                                            Description
Oct 25, 2022			Chandra Sekhar Reddy Muthumula					Added Class MultiplyStrings 
Oct 25, 2022			Chandra Sekhar Reddy Muthumula					Added multiply
--------------------------------------------------------------------------------------------------
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
-------------------------------------------------------------------------------------------
*/
package Problems.MultiplyStrings;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int len = l1 + l2;
        int[] arr = new int[len];
        for(int i = 0; i < l2; i++) {
            int a = num2.charAt(l2 - 1 - i) - '0';
            for (int j = 0; j < l1; j++) {
                int b = num1.charAt(l1 - 1 -j) - '0';
                int total = a * b;
                arr[(len - 1) - (i + j)] += total;
                arr[(len - 2) - (i + j)] += arr[(len - 1) - (i + j)] / 10;
                arr[(len - 1) - (i + j)] %= 10;
            }
        }
        String result = "";
        int index = 0;
        while(index < len && arr[index] == 0) index++; 
        for (int i = index; i < len; i++) {
            result += arr[i];
        }
        if(result == "") {
            return "0";
        }
        return result;
    }
}