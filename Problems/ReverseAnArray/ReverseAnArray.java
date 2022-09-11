/*
Class Name  : ReverseAnArray
Description : This class is used to find the First Three maximum elemets of the given array of integers.
Date        : Sep 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: NA

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added reverseAnArrayMethod1 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added reverseAnArrayMethod2 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added reverseAnArrayMethod3
*/
import java.io.*; 
import java.util.*;

public class ReverseAnArray {
	public static void main(String[] args) {
		//Test Casaes
		int [] testArray = {1,2,3,4,5};
		System.out.println("Original array : " +Arrays.toString(testArray) + " -> Reversed Array : " + Arrays.toString(reverseAnArrayMethod1(testArray)) );
		
		int [] testArray1 = {0,2,3,4,5};
		System.out.println("Original array : " +Arrays.toString(testArray1) + " -> Reversed Array : " + Arrays.toString(reverseAnArrayMethod2(testArray1)) );
		
		int [] testArray2 = {0,2,3,4,5};
		System.out.println("Original array : " +Arrays.toString(testArray2) + " -> Reversed Array : " + Arrays.toString(reverseAnArrayMethod2(testArray2)) );
		
		int [] testArray3 = {0,2,3,4,5};
		System.out.println("Original array : " +Arrays.toString(testArray3) + " -> Reversed Array : " + Arrays.toString(reverseAnArrayMethod3(testArray3)) );
		
	}
	
	/*
	Method Name : reverseAnArrayMethod1
	Input       : int[] arr
	Description : This method reverses an array by using a basic logic
	TC          : O(N)
	SC          : O(N)
	Recommended : NO
	*/
	public static int[] reverseAnArrayMethod1 (int[] arr) {
		int[] reverseArray = new int [arr.length];
		for (int i=arr.length-1; i>=0; i--) {
			reverseArray[arr.length-1-i] = arr[i];
		}
		return reverseArray;
	}
	
	/*
	Method Name : reverseAnArrayMethod2
	Input       : int[] arr
	Description : This method reverses an array by swaping using start and end params;
	TC          : O(N/2)
	SC          : O(1)
	Recommended : Highly
	*/
	public static int[] reverseAnArrayMethod2 (int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while (start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
		return arr;
	}
	
	/*
	Method Name : reverseAnArrayMethod2
	Input       : int[] arr
	Description : This method reverses an array by swaping in a for loop till n/2;
	TC          : O(N/2)
	SC          : O(1)
	Recommended : Highly
	*/
	public static int[] reverseAnArrayMethod3 (int[] arr) {
		int n = arr.length;
		for (int i=0; i<n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-i-1] = temp;
		}
		return arr;
	}
}

/*
OUTPUT:

Original array : [1, 2, 3, 4, 5] -> Reversed Array : [5, 4, 3, 2, 1]
Original array : [0, 2, 3, 4, 5] -> Reversed Array : [5, 4, 3, 2, 0]
Original array : [0, 2, 3, 4, 5] -> Reversed Array : [5, 4, 3, 2, 0]
Original array : [0, 2, 3, 4, 5] -> Reversed Array : [5, 4, 3, 2, 0]

*/