/*
Class Name  : ANumberAfterDoubleReversal
Description : This class consists of the solution for ANumberAfterDoubleReversal.
Date        : Oct 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/a-number-after-a-double-reversal/
Modification Log: 
Date					Name                                            Description
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class ANumberAfterDoubleReversal 
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added isSameAfterReversals 
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added reverseNumber
--------------------------------------------------------------------------------------------------
2119. A Number After a Double Reversal
Reversing an integer means to reverse all its digits.
For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2. 
Return true if reversed2 equals num. Otherwise return false.

Example 1:
Input: num = 526
Output: true
Explanation: Reverse num to get 625, then reverse 625 to get 526, which equals num.

Example 2:
Input: num = 1800
Output: false
Explanation: Reverse num to get 81, then reverse 81 to get 18, which does not equal num.

Example 3:
Input: num = 0
Output: true
Explanation: Reverse num to get 0, then reverse 0 to get 0, which equals num.
------------------------------------------------------------------------------------------------------
*/

package Problems.ANumberAfterDoubleReversal;

public class ANumberAfterDoubleReversal {
    public boolean isSameAfterReversals(int num) {
        int firstReverse = reverseNumber(num, 0);
        if (num == reverseNumber(firstReverse, 0)) {
            return true;
        } else return false;
          
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