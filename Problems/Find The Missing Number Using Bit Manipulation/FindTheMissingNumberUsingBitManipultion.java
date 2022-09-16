/*
Class Name  : FindTheMissingNumberUsingBitManipultion
Description : This class consists of the solution for FindTheMissingNumberUsingBitManipultion.
Date        : Sep 16, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.youtube.com/watch?v=E7thKCWmP98&list=PLfQN-EvRGF39Vz4UO18BtA1ocnUhGkvk5&index=14&ab_channel=CodesYourMind
Modification Log: 
Date					Name                                            Description
Sep 16, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindTheMissingNumberUsingBitManipultion 
Sep 16, 2022			Chandra Sekhar Reddy Muthumula					Added findTheMissingNumberUsingBitManipultion 
--------------------------------------------------------------------------------------------------
283. Find The Missing Number Using Bit Manipultion

Given an integer array nums, and the integer N, which contains the integers from 1 to N, with a missing element in between.
Find the missing number using bit manipulation.

Example :
Input: nums = [1,3,5,2]
Output: 4


*/
public class FindTheMissingNumberUsingBitManipultion {
	public static void main (String[] args) {
		// Test Cases
		System.out.println("Input array is {1,3,4,5} and N is 5 -> Missing Number is : " + findTheMissingNumberUsingBitManipultion(new int [] {1,3,4,5}, 5));
		System.out.println("Input array is {1,2,3,4,5,6} and N is 7 -> Missing Number is : " + findTheMissingNumberUsingBitManipultion(new int [] {1,2,3,4,5,6}, 7));
		System.out.println("Input array is {1} and N is 1 -> Missing Number is : " + findTheMissingNumberUsingBitManipultion(new int [] {1}, 1));
		System.out.println("Input array is {1,2,3,4,6,7,8,9} and N is 9 -> Missing Number is : " + findTheMissingNumberUsingBitManipultion(new int [] {1,2,3,4,6,7,8,9}, 9));
	}
	
	public static int findTheMissingNumberUsingBitManipultion (int[] arr, int N) {
		if (arr.length <= 1) {
			return -1;
		}
		int result = 0;
		for (int i=0; i<N-1; i++) {
			result = result ^ arr[i] ^ (i+1);
		}
		return result ^ N;
	}
	
}
/*
OUTPUT:
Input array is {1,3,4,5} and N is 5 -> Missing Number is : 2
Input array is {1,2,3,4,5,6} and N is 7 -> Missing Number is : 7
Input array is {1} and N is 1 -> Missing Number is : -1
Input array is {1,2,3,4,6,7,8,9} and N is 9 -> Missing Number is : 5
*/