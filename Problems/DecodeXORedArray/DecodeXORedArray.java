/*
Class Name  : DecodeXORedArray
Description : This class consists of the solution for DecodeXORedArray.
Created Date: Dec 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/decode-xored-array/
Modification Log: 
Date					Name                                            Description
Dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class DecodeXORedArray 
Dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added decode
--------------------------------------------------------------------------------------------------
1720. Decode XORed Array
Easy
1.1K
173
Companies
There is a hidden integer array arr that consists of n non-negative integers.

It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].

You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].

Return the original array arr. It can be proved that the answer exists and is unique.

 

Example 1:

Input: encoded = [1,2,3], first = 1
Output: [1,0,2,1]
Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
Example 2:

Input: encoded = [6,2,7,3], first = 4
Output: [4,2,0,7,4]
 

Constraints:

2 <= n <= 104
encoded.length == n - 1
0 <= encoded[i] <= 105
0 <= first <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.DecodeXORedArray;

public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] decodedArray = new int[len + 1];
        decodedArray[0] = first;
        for (int i = 1; i < len + 1; i++) {
            decodedArray[i] = decodedArray[i - 1] ^ encoded[i - 1];
        }
        return decodedArray;
    }
}
