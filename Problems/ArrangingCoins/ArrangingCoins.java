/*
Class Name  : ArrangingCoins
Description : This class consists of the solution for ArrangingCoins.
Date        : Nov 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/arranging-coins/description/

Modification Log: 
Date				    Name                                            Description
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class ArrangingCoins 
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added arrangeCoins
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added arrangeCoinsBinarySearch
--------------------------------------------------------------------------------------------------
441. Arranging Coins
Easy
2.8K
1.1K
Companies
You have n coins and you want to build a staircase with these coins. 
The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 

Constraints:

1 <= n <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.ArrangingCoins;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        /*
         * TC : O(N ^ 0.5)
         * SC : O(1)
        */
        long l = n;
        long i = (long) Math.sqrt(l * 2);
        while ((i * (i + 1)) / 2 > n) {
            i--;
        }
        return (int) i;
    }

    public int arrangeCoinsBinarySearch(int n) {
        /*
         * TC : O(LogN)
         * SC : O(1)
        */
        if (n == 1) {
            return n;
        }
        if (n <= 3) {
            return n == 3 ? 2 : 1;
        }
        int start = 2;
        int end = n / 2;

        while (start <= end) {
            long mid = start + ((end - start) >> 1);
            long total_coins = (mid * (mid + 1)) / 2;
            if (total_coins == n) {
                return (int) mid;
            } else if (total_coins < n) {
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }
        return end;
    }
}