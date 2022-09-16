/*
Class Name  : SubsetsOfArray
Description : This class consists of the solution for SubsetsOfArray.
Date        : Sep 16, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.youtube.com/watch?v=0AAjJvlq5Is&list=PLfQN-EvRGF39Vz4UO18BtA1ocnUhGkvk5&index=16&ab_channel=CodesYourMind
Modification Log: 
Date					Name                                            Description
Sep 16, 2022			Chandra Sekhar Reddy Muthumula					Added Class SubsetsOfArray 
Sep 16, 2022			Chandra Sekhar Reddy Muthumula					Added solutionMethod 
Sep 16, 2022			Chandra Sekhar Reddy Muthumula					Changed ino the Subset Money problem
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
public class SubsetsOfArray {
	public static void main (String[] args) {
		// Test Cases
		System.out.println(solutionMethod(new int [] {1,2,3}, 5));
		System.out.println("--------------------------------------------------");
		System.out.println(solutionMethod(new int [] {4,2,3}, 8));
		System.out.println("--------------------------------------------------");
		System.out.println(solutionMethod(new int [] {1,5,7,4,2,3}, 21));
		System.out.println("--------------------------------------------------");
	}
	
	public static boolean solutionMethod (int[] arr, int money) {
		System.out.println("money : " + money);
		if (arr.length <= 0) {
			System.out.println("Invalid Input");
		}
		int total = 1<<arr.length;
		
		for (int k=1; k<total-1; k++) {
			int subsetSum = 0;
			for (int i=0; i<arr.length; i++) {
				
				// System.out.println("Data -> " + (k & (1<<i)));
				if ( ((k>>i)&1) == 1 ) {
					subsetSum += arr[i];
					// System.out.print(arr[i] + " ");
				}
			}
			//System.out.println("subsetSum : " + subsetSum);
			
			if (money == subsetSum)  {
				//System.out.println("money == subsetSum"); 
				return true;
			} else {
				continue;
			}
			//System.out.println();
		}
		return false;
		
	}
	
}

/*
OUTPUT:
money : 5
true
--------------------------------------------------
money : 8
false
--------------------------------------------------
money : 21
true
--------------------------------------------------
*/