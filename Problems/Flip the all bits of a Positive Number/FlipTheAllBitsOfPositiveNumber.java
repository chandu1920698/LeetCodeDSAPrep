/*
Class Name  : Flip the all bits of a Positive Number | Bit Manipulation
Description : This class consists of the solution for FlipTheAllBitsOfPositiveNumber.
Date        : Sep 16, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.youtube.com/watch?v=4zXNepgAvUg&list=PLfQN-EvRGF39Vz4UO18BtA1ocnUhGkvk5&index=15&ab_channel=CodesYourMind
Modification Log: 
Date					Name                                            Description
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class FlipTheAllBitsOfPositiveNumber 
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added solutionMethod 
--------------------------------------------------------------------------------------------------
Problem Statement: Find The Unique Two Numbers Using Bit Manipultion

You are given an array of Integers. 
The special property of the arrray is that exactly two different elemenst occur once, while others occur twice.
You are required to determine those two elements.

Example :
Input: num = 10 -> 1010 (binary)
Output: 5 (= 0101)


*/
import java.util.*;
public class FlipTheAllBitsOfPositiveNumber {
	public static void main (String[] args) {
		// Test Cases
		
		System.out.println("Input Number is 10 -> The output Number is : " + solutionMethod(10));
		System.out.println("Input Number is 1 -> The output Number is : " + solutionMethod(1));
		System.out.println("Input Number is 2 -> The output Number is : " + solutionMethod(2));
		System.out.println("Input Number is 3 -> The output Number is : " + solutionMethod(3));
		System.out.println("Input Number is 7 -> The output Number is : " + solutionMethod(7));
		System.out.println("Input Number is 15 -> The output Number is : " + solutionMethod(15));
		System.out.println("Input Number is 31 -> The output Number is : " + solutionMethod(31));
		
	}
	
	public static int solutionMethod (int N) {
		if (N <= -1) {
			return -1;
		}
		
		int pos = (int) (Math.log(N)/Math.log(2));
		// System.out.println("pos -> " + pos);
		// System.out.println("XOR1 -> " + (1<<pos));
		// System.out.println("XOR1 - 1 -> " + ((1<<pos)-1));
		// System.out.println("OR -> " +  (((1<<pos))| ((1<<pos)-1)));
		// System.out.println("XOR -> " + ( (1<<(pos-1)) | ((1<<pos)-1) ));
		return N ^ (((1<<pos))| ((1<<pos)-1));
	}
	
}