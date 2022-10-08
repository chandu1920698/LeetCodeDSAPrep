/*
Class Name  : NextGreaterElement3
Description : This class consists of the solution for NextGreaterElement3.
Date        : Oct 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/next-greater-element-iii/

Modification Log: 
Date				Name                                            Description
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class NextGreaterElement3 
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added maxProduct
--------------------------------------------------------------------------------------------------
556. Next Greater Element III

Given a positive integer n, 
find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, 
if there is a valid answer but it does not fit in 32-bit integer, return -1.

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.NextGreaterElement3;

public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        int number = n;
        int len = (int) ((Math.log(n)/Math.log(10))+1);
        int[] digits = new int[len];
        
        for(int i=0; i<len; i++) {
            digits[len-1-i] = number%10;
             number /= 10;
        }
        // System.out.println("Digits : " + Arrays.toString(digits));
        
        int minIndex = len - 2;
        int maxIndex = len - 1;
        
        while(minIndex >= 0 && digits[minIndex] >= digits[minIndex + 1]) minIndex--;
        
        if(minIndex < 0) return -1; 
        
        while(digits[maxIndex] <= digits[minIndex]) maxIndex--;
        
        swap(digits, minIndex, maxIndex);
        // System.out.println("Digits 1: " + Arrays.toString(digits));
        reverse(digits, minIndex+1, len-1); 
        // System.out.println("Digits 2: " + Arrays.toString(digits));
        int result = 0;
        
        for (int i=0; i<len; i++) {
            if ( result  > Integer.MAX_VALUE/10 || (result  >= Integer.MAX_VALUE/10 && digits[i] > Integer.MAX_VALUE%10)) {
                return -1;
            }
            result = result*10 + digits[i];
                        
            // System.out.println("Result : " + result);
        }
        return result; 
    }
    
    public int[] swap(int[] digits, int i, int j) {
        digits[i] ^= digits[j];
        digits[j] ^= digits[i];
        digits[i] ^= digits[j];
        return digits;
    }
    public int[] reverse(int[] digits, int start, int end) {
        while(start < end) {
            swap(digits, start++, end--);
        }
        return digits;
    }
}