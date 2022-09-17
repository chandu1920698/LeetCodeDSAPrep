/*
Class Name  : Numberof1Bits
Description : This class consists of the solution for Numberof1Bits.
Date        : Sep 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/number-of-1-bits/
Modification Log: 
Date					Name                                            Description
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class Numberof1Bits 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added hammingWeight 
--------------------------------------------------------------------------------------------------
191. Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. 
In this case, the input will be given as a signed integer type. 
It should not affect your implementation, as the integer's internal binary representation is the same, 
whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. 
Therefore, in Example 3, the input represents the signed integer. -3.
 

Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Example 3:
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

Constraints:

The input must be a binary string of length 32.
 

Follow up: If this function is called many times, how would you optimize it?
------------------------------------------------------------------------------------------------------
*/

public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int setBitsCount = 0;
        // if (n >= 0){
        //     System.out.println("n: " + n);
        //     int totalBits = (int) (Math.log(n)/Math.log(2)+1);
        //     System.out.println("totalBits: " + totalBits);
        //     for (int i=0; i<totalBits; i++) {
        //         if (((n>>>i) & 1) == 1) {
        //             System.out.println("n>>" +i +" : " + (n>>i));
        //             setBitsCount++;
        //             //n >>= 1;
        //         }
        //     }
        // } 
        // return setBitsCount;
        
        int count = 0;
        while(n!=0){
            if((n & 1) == 1){
              count++;   
            }
            n = n>>>1;//using ">>>" because n is an unsigned value so we use unsigned right shift operator
        } 
        return count;
    }
}