/*
Class Name  : FirstLastOccurrenceInArray
Description : This class consists of the solution for ReverseInteger.
Date        : Sep 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/reverse-integer/
Modification Log: 
Date					Name                                            Description
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class FirstLastOccurrenceInArray 
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added firstLastOccurrenceInArray
--------------------------------------------------------------------------------------------------
7. Reverse Integer

Given an integer of Arrays and the keys. Return the first and last occurrences of the key else return -1;

------------------------------------------------------------------------------------------------------
*/
import java.util.*;
class FirstLastOccurrenceInArray {
	public static void main(String[] args) {
		// Test Cases
		System.out.println("Input Array : {0,1,2,3,5,1} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,1,2,3,5,1}, 0)));
		System.out.println("Input Array : {0,1,2,3,5,1} , Key : 9   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,1,2,3,5,1}, 9)));
		System.out.println("Input Array : {0,1,1,3,5,1} , Key : 1   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,1,2,3,5,1}, 1)));
		System.out.println("Input Array : {0,0,0,0,0,0} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,0,0,0,0,0}, 0)));
		System.out.println("Input Array : {0} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0}, 0)));
		System.out.println("Input Array : {} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {}, 0)));
		// System.out.println("Input Array : {0,1,2,3,5,1} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,1,2,3,5,1}, 0)));
		// System.out.println("Input Array : {0,1,2,3,5,1} , Key : 0   -> First and Last Occurrences indices : " + Arrays.toString(firstLastOccurrenceInArray(new int [] {0,1,2,3,5,1}, 0)));
	}
    public static int[] firstLastOccurrenceInArray(int[] arr, int key) {
		if (arr.length < 1) {
			return new int [] {-1,-1};
		}
	    int firstOccurrence = -1;
		int lastOccurrence = -1;
		boolean firstOccurrenceFlag = false;
		for (int i=0; i<arr.length; i++) {
			if (key == arr[i]) {
				lastOccurrence = i;
				if (!firstOccurrenceFlag) {
					firstOccurrence = i;
					firstOccurrenceFlag = true;
				}
			}
		}
        return new int[] {firstOccurrence, lastOccurrence};
    }
}

/*
OUTPUT:
Input Array : {0,1,2,3,5,1} , Key : 0   -> First and Last Occurrences indices : [0, 0]
Input Array : {0,1,2,3,5,1} , Key : 9   -> First and Last Occurrences indices : [-1, -1]
Input Array : {0,1,1,3,5,1} , Key : 1   -> First and Last Occurrences indices : [1, 5]
Input Array : {0,0,0,0,0,0} , Key : 0   -> First and Last Occurrences indices : [0, 5]
Input Array : {0} , Key : 0   -> First and Last Occurrences indices : [0, 0]
Input Array : {} , Key : 0   -> First and Last Occurrences indices : [-1, -1]
*/