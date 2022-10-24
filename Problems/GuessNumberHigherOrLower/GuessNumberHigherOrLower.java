/*
Class Name  : GuessNumberHigherOrLower
Description : This class consists of the solution for GuessNumberHigherOrLower.
Date        : Oct 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/guess-number-higher-or-lower/

Modification Log: 
Date					Name                                            Description
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class GuessNumberHigherOrLower 
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added guessNumber 
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added guess 
--------------------------------------------------------------------------------------------------
374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

 

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
 

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
-------------------------------------------------------------------------------------------
*/package Problems.GuessNumberHigherOrLower;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }else if(res == 1) {
                start = mid + 1;
            } else {
               end = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        // This method is an internal one from leet code
        return 0;
    }
}