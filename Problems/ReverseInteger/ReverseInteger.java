/*
Class Name  : ReverseInteger
Description : This class consists of the solution for ReverseInteger.
Date        : Sep 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/reverse-integer/
Modification Log: 
Date					Name                                            Description
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class ReverseInteger 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added reverse 
--------------------------------------------------------------------------------------------------
7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).


Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 

Constraints:

-2^31 <= x <= 2^31 - 1

------------------------------------------------------------------------------------------------------
*/

class ReverseInteger {
    public int reverse(int x) {
        
        // This is a normal Iteration method
        // int reverse = 0;
        // int max = Integer.MAX_VALUE;
        // int min = Integer.MIN_VALUE;
        // while (x != 0) {
        //     if ( ((reverse > max/10) || (reverse >= max/10 && x%10 >= max%10)) || ((reverse < min/10) || (reverse <= min/10 && x%10 <= min%10)) ) {
        //         //System.out.println("Exceed");
        //         return 0;
        //     }
        //     reverse = reverse*10 + x%10;
        //     x/= 10;
        //     //System.out.println("reverse -> " + reverse);
        // }
        // return reverse;

        
        // This is a recursive method
        return  reverseNumber(x, 0);
    }
    

     private static int reverseNumber(int n, int reverse) {
        /*
        * N  : No of digits in the integer
        * TC : O(N)
        * SC : O(N)
        */
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (Math.abs(n) > 0) {
            if ((reverse > max/10 || (reverse >= max/10 && n%10 >= max%10) )|| (reverse < min/10 || (reverse <= min/10 && n%10 <= min%10)) ) {
                // return n < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return 0;
            } else {
                reverse = reverse*10 + n%10;
                n /= 10;
                return reverseNumber(n, reverse);
            }
        }
        return reverse;
    }
}