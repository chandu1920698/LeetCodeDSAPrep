/*
Class Name  : FindTheUniqueTwoNumbersUsingBitManipultion
Description : This class consists of the solution for FindTheMissingNumberUsingBitManipultion.
Date        : Sep 16, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.youtube.com/watch?v=DvNItnE2k0g&list=PLfQN-EvRGF39Vz4UO18BtA1ocnUhGkvk5&index=14&ab_channel=CodesYourMind
Modification Log: 
Date					Name                                            Description
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindTheUniqueTwoNumbersUsingBitManipultion 
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added solutionMethod 
--------------------------------------------------------------------------------------------------
Problem Statement: Find The Unique Two Numbers Using Bit Manipultion

You are given an array of Integers. 
The special property of the arrray is that exactly two different elemenst occur once, while others occur twice.
You are required to determine those two elements.

Example :
Input: nums = [1,2,3,4,5,3,4,5]
Output: [1,2]


*/
import java.util.*;
public class FindTheUniqueTwoNumbersUsingBitManipultion {
	public static void main (String[] args) {
		// Test Cases
		int [] result = solutionMethod(new int [] {1,2,3,4,5,3,4,5});
		System.out.println("Input array is {1,2,3,4,5,3,4,5} -> The Two Numbers are : " + Arrays.toString(result));
		
		result = solutionMethod(new int [] {1,3,4,5,6,7,3,4,5,6,7,9});
		System.out.println("Input array is {1,3,4,5,6,7,3,4,5,6,7,9} -> The Two Numbers are : " + Arrays.toString(result));
		
		result = solutionMethod(new int [] {1,3});
		System.out.println("Input array is {1,3} -> The Two Numbers are : " + Arrays.toString(result));
		
		result = solutionMethod(new int [] {100,3,4,5,6,7,3,4,5,6,7,989});
		System.out.println("Input array is {1,3,4,5,6,7,3,4,5,6,7,9} -> The Two Numbers are : " + Arrays.toString(result));
		
	}
	
	public static int[] solutionMethod (int[] arr) {
		if (arr.length <= 2) {
			return new int [] {-1,-1};
		}
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result = result ^ arr[i];
		}
		
		int pos = (int) (Math.log(result)/Math.log(2) + 1);
		// System.out.println("pos -> " + pos + " left shift : " + (1 << (pos-1)));
		int y1 = 0;
		int y2 = 0;
		
		for (int val : arr) {
			if ((val >> (pos-1) & 1) == 1) {
				// System.out.println("y1 -> " + val);
				y1 ^= val;
			}else {
				// System.out.println("y2 -> " + val + " : bit -> " + (val & (1 << (pos-1))));
				y2 ^= val;
			}
		}
		return new int[] {Math.min(y1,y2), Math.max(y1,y2)};
	}
	
}