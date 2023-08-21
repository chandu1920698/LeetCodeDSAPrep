
/*
Class Name  : PrimeInDiagonal
Description : This class consists of the solution for PrimeInDiagonal.
Date        : Apr 09, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/contest/weekly-contest-340/problems/prime-in-diagonal/

Modification Log: 
Date					Name                                            Description
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added Class PrimeInDiagonal 
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added primeInDiagonal 
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added isPrime
--------------------------------------------------------------------------------------------------
2614. Prime In Diagonal
User Accepted:9492
User Tried:11629
Total Accepted:9981
Total Submissions:36751
Difficulty:Easy
You are given a 0-indexed two-dimensional integer array nums.

Return the largest prime number that lies on at least one of the diagonals of nums. In case, no prime is present on any of the diagonals, return 0.

Note that:

An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
An integer val is on one of thediagonals of nums if there exists an integer i for which nums[i][i] = val or an i for which nums[i][nums.length - i - 1]= val.


In the above diagram, one diagonal is [1,5,9] and another diagonal is [3,5,7].

 

Example 1:

Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
Output: 11
Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.
Example 2:

Input: nums = [[1,2,3],[5,17,7],[9,11,10]]
Output: 17
Explanation: The numbers 1, 3, 9, 10, and 17 are all present on at least one of the diagonals. 17 is the largest prime, so we return 17.
 

Constraints:

1 <= nums.length <= 300
nums.length == numsi.length
1 <= nums[i][j] <= 4*106
-------------------------------------------------------------------------------------------
*/
package Problems.PrimeInDiagonal;

public class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i][i] > 1 && isPrime(nums[i][i])) {
                if(maxPrime < nums[i][i]) {
                    maxPrime = nums[i][i];
                }
            }
            if(nums[i][i] > 1 && isPrime(nums[i][len - 1 - i])) {
                if(maxPrime < nums[i][len - 1 - i]) {
                    maxPrime = nums[i][len - 1 - i];
                }
            }
        }
        return maxPrime;
    }
    
    private boolean isPrime(int num) {
        int sqrt = (int)Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) {
            if(num % (i) == 0) {
                return false;
            }    
        }
        return true;
    }
}