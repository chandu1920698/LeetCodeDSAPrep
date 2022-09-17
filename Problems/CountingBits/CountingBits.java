/*
Class Name  : CountingBits
Description : This class consists of the solution for CountingBits.
Date        : Sep 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/counting-bits/
Modification Log: 
Date					Name                                            Description
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class CountingBits 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added countBits 
--------------------------------------------------------------------------------------------------
338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
ans[i] is the number of 1's in the binary representation of i.

 

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 10^5
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). 
Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
------------------------------------------------------------------------------------------------------
*/

class CountingBits {
    public int[] countBits(int n) {
        int[] countBitsArray = new int[n+1];
		// Method 1
		/*
		TC 			: O(NLog(N))
		SC 			: O(1)
		Recommended : Slightly not recommended
		*/
		
        // for (int i=0; i<=n; i++) {
        //     int totalBits = (int) (Math.log(i)/Math.log(2)+1);
        //     // System.out.println("totalBits : " + i + " -> "  + totalBits);
        //     int setBitsCount = 0;
        //     for (int j=0; j<totalBits; j++) {
        //         if(((i >> j) & 1) == 1) {
        //             setBitsCount++;
        //         }
        //     }
        //     // System.out.println("setBitsCount : " + i + " -> "  + setBitsCount);
        //     countBitsArray[i] = setBitsCount;
        // }
        
		// Method 2
		/*
		TC 			: O(N)
		SC 			: O(N)
		Recommended : YES
		*/
        for (int i=0; i<=n; i++) {
			//even number : number of bits is number of bits in [number/2]
            //odd number  : number of bits is number of bits in [number/2]+1
            countBitsArray[i] = countBitsArray[i/2] + i%2;
        }
        return countBitsArray;
    }
}

