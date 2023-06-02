/*
Class Name  : ValidPerfectSquare
Description : This class consists of the solution for ValidPerfectSquare.
Date        : Jun 02, 2023
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/valid-perfect-square/description/

Modification Log: 
Date				    Name                                            Description
Jun 02, 2023			Chandra Sekhar Reddy Muthumula					Added Class ValidPerfectSquare 
Jun 02, 2023			Chandra Sekhar Reddy Muthumula					Added isPerfectSquare
--------------------------------------------------------------------------------------------------
367. Valid Perfect Square
Easy
3.6K
280
Companies
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 

Constraints:

1 <= num <= 231 - 1
-------------------------------------------------------------------------------------------
*/

package Problems.ValidPerfectSquare;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int start = 1, end = num / 2;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            long midSquare = mid * mid;
            System.out.println("mid : " + mid);
            if(midSquare == num) {
                return true;
            } else if(midSquare < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}