/*
Class Name  : WarmUpPractiseSet
Description : This class consists of problems of warm up pracctise set.
Date        : Sep 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: NA

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added arraySum 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added printElementOfIndex 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added noOfElementsLessthanOrEqualToKey
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added printEvenIndexedElements
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added question5
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added question6
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added question7
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added question8
Sep 12, 2022			Chandra Sekhar Reddy Muthumula					Added question9
Sep 12, 2022			Chandra Sekhar Reddy Muthumula					Added question10
Sep 12, 2022			Chandra Sekhar Reddy Muthumula					Added bonusQuestion
*/

import java.io.*; 
import java.util.*;

public class WarmUpPractiseSet {
	public static void main (String[] args) {
	// Test Cases for array sum
	System.out.println("arraySum : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + arraySum(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + arraySum(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + arraySum(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + arraySum(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + arraySum(new int [] {}));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for printElementOfIndex
	System.out.println("printElementOfIndex : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7} , key : 1 : result -> " + printElementOfIndex(new int [] {1,3,5,6,7}, 1));
	System.out.println("Input Array : {0,0,0,0,0} , key : 2 : result -> " + printElementOfIndex(new int []  {0,0,0,0,0}, 2));
	System.out.println("Input Array : {1} , key : 1 : result -> " + printElementOfIndex(new int []  {1}, 2));
	System.out.println("Input Array : {-1,0,1} , key : 2 : result -> " + printElementOfIndex(new int []  {-1,0,1},2));
	System.out.println("Input Array : {}  , key : 0: result -> " + printElementOfIndex(new int []  {},0));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for noOfElementsLessthanOrEqualToKey
	System.out.println("noOfElementsLessthanOrEqualToKey : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7} , key : 6 : result -> " + noOfElementsLessthanOrEqualToKey(new int [] {1,3,5,6,7}, 6));
	System.out.println("Input Array : {0,0,0,0,0} , key : 2 : result -> " + noOfElementsLessthanOrEqualToKey(new int []  {0,0,0,0,0}, 2));
	System.out.println("Input Array : {1} , key : 2 : result -> " + noOfElementsLessthanOrEqualToKey(new int []  {1}, 2));
	System.out.println("Input Array : {-1,0,1} , key : 2 : result -> " + noOfElementsLessthanOrEqualToKey(new int []  {-1,0,1},2));
	System.out.println("Input Array : {} , key : 0 : result -> " + noOfElementsLessthanOrEqualToKey(new int []  {},0));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for printEvenIndexedElements
	System.out.println("printEvenIndexedElements : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + printEvenIndexedElements(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + printEvenIndexedElements(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + printEvenIndexedElements(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + printEvenIndexedElements(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + printEvenIndexedElements(new int []  {}));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for question5
	System.out.println("question5 : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + question5(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + question5(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + question5(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + question5(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + question5(new int []  {}));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for question6
	System.out.println("question6 : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + question6(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + question6(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + question6(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + question6(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + question6(new int []  {}));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for question7
	System.out.println("question7 : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + question7(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + question7(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + question7(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + question7(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + question7(new int []  {}));
	System.out.println("---------------------------------------------------------------------");

	
	// Test Cases for question8
	System.out.println("question8 : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,6,7}  : result -> " + question8(new int [] {1,3,5,6,7}));
	System.out.println("Input Array : {0,0,0,0,0}  : result -> " + question8(new int []  {0,0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + question8(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + question8(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + question8(new int []  {}));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for question9
	System.out.println("question9 : ---------------------------------------------------------");
	System.out.println("Input Number : 10  : result -> " + question9(10));
	System.out.println("Input Number : 0  : result -> " + question9(0));
	System.out.println("Input Number : 100  : result -> " + question9(100));
	System.out.println("Input Number : 200  : result -> " + question9(200));
	System.out.println("Input Number : -10  : result -> " + question9(-10));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for question10
	System.out.println("question10 : ---------------------------------------------------------");
	System.out.println("Input Number : 192  : result -> " + question10(192));
	System.out.println("Input Number : 300  : result -> " + question10(300));
	System.out.println("Input Number : 100  : result -> " + question10(100));
	System.out.println("Input Number : 200  : result -> " + question10(200));
	System.out.println("Input Number : -10  : result -> " + question10(-10));
	System.out.println("---------------------------------------------------------------------");
	
	// Test Cases for bonusQuestion
	System.out.println("bonusQuestion : ---------------------------------------------------------");
	System.out.println("Input Array : {1,3,5,7}  : result -> " + bonusQuestion(new int [] {1,3,5,7}));
	System.out.println("Input Array : {0,0,0,0}  : result -> " + bonusQuestion(new int []  {0,0,0,0}));
	System.out.println("Input Array : {1}  : result -> " + bonusQuestion(new int []  {1}));
	System.out.println("Input Array : {-1,0,1}  : result -> " + bonusQuestion(new int []  {-1,0,1}));
	System.out.println("Input Array : {}  : result -> " + bonusQuestion(new int []  {}));
	System.out.println("---------------------------------------------------------------------");
	
	}
	
	
	public static long arraySum (int [] arr) {
		long sum = 0;
		if (arr.length < 1) {
			return -1;
		}
		for (int arrItem : arr) {
			sum += arrItem;
		}
		return sum;
	}
	/*
	OUTPUT:
	arraySum : ---------------------------------------------------------
	Input Array : {1,3,5,6,7}  : result -> 22
	Input Array : {0,0,0,0,0}  : result -> 0
	Input Array : {1}  : result -> 1
	Input Array : {-1,0,1}  : result -> 0
	Input Array : {}  : result -> -1
	---------------------------------------------------------------------
	*/
	
	
	public static int printElementOfIndex (int [] arr, int index) {
		if (arr.length < 1 || index < 0 || index >= arr.length) {
			return -1;
		}
		//System.out.println("Element at Index : " + index + "is " + arr[index]);
		return arr[index];
	}
	
	/*
	OUTPUT:
	printElementOfIndex : ---------------------------------------------------------
	Input Array : {1,3,5,6,7} , key : 1 : result -> 3
	Input Array : {0,0,0,0,0} , key : 2 : result -> 0
	Input Array : {1} , key : 1 : result -> -1
	Input Array : {-1,0,1} , key : 2 : result -> 1
	Input Array : {}  , key : 0: result -> -1
	---------------------------------------------------------------------
	*/
	
	
	public static int noOfElementsLessthanOrEqualToKey (int [] arr, int key) {
		if (arr.length < 1) {
			return -1;
		}
		int count = 0;
		for (int arrItem : arr) {
			if (arrItem <= key) {
				count++;
			}
		}
		return count;
	}
	
	/*
	OUTPUT:
	noOfElementsLessthanOrEqualToKey : ---------------------------------------------------------
	Input Array : {1,3,5,6,7} , key : 6 : result -> 4
	Input Array : {0,0,0,0,0} , key : 2 : result -> 5
	Input Array : {1} , key : 2 : result -> 1
	Input Array : {-1,0,1} , key : 2 : result -> 3
	Input Array : {} , key : 0 : result -> -1
	---------------------------------------------------------------------
	*/
	
	
	public static String printEvenIndexedElements (int [] arr) {
		if (arr.length < 1) {
			return "Invalid Input";
		}
		for (int i=0; i<=arr.length-1; i+=2) {
			System.out.print(arr[i] + " ");
		}
		return "The method itself is printing";
	}
	/*
	OUTPUT:
	printEvenIndexedElements : ---------------------------------------------------------
	1 5 7 Input Array : {1,3,5,6,7}  : result -> The method itself is printing
	0 0 0 Input Array : {0,0,0,0,0}  : result -> The method itself is printing
	1 Input Array : {1}  : result -> The method itself is printing
	-1 1 Input Array : {-1,0,1}  : result -> The method itself is printing
	Input Array : {}  : result -> Invalid Input
	---------------------------------------------------------------------
	*/
	
	
	public static String question5 (int [] arr) {
		if (arr.length < 1) {
			return "Invalid Input";
		}
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == i+1) {
				System.out.println(i+1);
			}
		}
		return "The method itself is printing";
	}
	/*
	OUTPUT:
	question5 : ---------------------------------------------------------
	1
	Input Array : {1,3,5,6,7}  : result -> The method itself is printing
	Input Array : {0,0,0,0,0}  : result -> The method itself is printing
	1
	Input Array : {1}  : result -> The method itself is printing
	Input Array : {-1,0,1}  : result -> The method itself is printing
	Input Array : {}  : result -> Invalid Input
	---------------------------------------------------------------------
	*/
	public static String question6 (int [] arr) {
		if (arr.length < 1) {
			return "Invalid Input";
		}
		for (int i=0; i<arr.length/2; i++) {
			if (arr[i] != arr[arr.length-1-i] ) {
				return "NOT PREFECT";
			}
		}
		return "PERFECT";
	}
	
	/*
	OUTPUT:
	question6 : ---------------------------------------------------------
	Input Array : {1,3,5,6,7}  : result -> NOT PREFECT
	Input Array : {0,0,0,0,0}  : result -> PERFECT
	Input Array : {1}  : result -> PERFECT
	Input Array : {-1,0,1}  : result -> NOT PREFECT
	Input Array : {}  : result -> Invalid Input
	---------------------------------------------------------------------
	*/
	
	
	public static String question7 (int [] arr) {
		if (arr.length < 1) {
			return "Invalid Input";
		}
        Arrays.sort(arr);
		System.out.print(arr[arr.length/2] + " " );
		return "The method itself is printing";
	}
	
	/*
	OUTPUT:
	question8 : ---------------------------------------------------------
	1 3 5 Input Array : {1,3,5,6,7}  : result -> The method itself is printing
	0 0 0 Input Array : {0,0,0,0,0}  : result -> The method itself is printing
	Input Array : {1}  : result -> Invalid Input
	-1 Input Array : {-1,0,1}  : result -> The method itself is printing
	Input Array : {}  : result -> Invalid Input
	---------------------------------------------------------------------
	*/
	
	
	public static String question8 (int [] arr) {
		if (arr.length < 2) {
			return "Invalid Input";
		}
        Arrays.sort(arr);
		for (int i=0; i<arr.length-2; i++) {
			System.out.print(arr[i] + " ");
		}
		return "The method itself is printing";
	}
	
	/*
	OUTPUT:
	
	*/
	
	
	public static long question9 (int N) {
		if (N < 0) {
			return -1;
		}
		
        long sum = ((N+1)*N)/2;
        return sum;
	}
	
	/*
	OUTPUT:
	question9 : ---------------------------------------------------------
	Input Number : 10  : result -> 55
	Input Number : 0  : result -> 0
	Input Number : 100  : result -> 5050
	Input Number : 200  : result -> 20100
	Input Number : -10  : result -> -1
	---------------------------------------------------------------------
	*/
	
	
	public static String question10 (long number) {
		if (number < 100) {
			return "Invalid Input";
		}
		String tempString = String.valueOf(number) + String.valueOf(number*2)+ String.valueOf(number*3);
		if (tempString.length() != 9) {
			return "Not Fascinating";
		} else {
			for (int i=0; i<tempString.length(); i++) {
				for (int j = i+1; j<tempString.length(); j++) {
					if (tempString.charAt(j)  == tempString.charAt(i)) {
						return "Not Fascinating";
					}
				}
			}
			return "Fascinating";
		}
	}
	
	/*
	OUTPUT:
	question10 : ---------------------------------------------------------
	Input Number : 192  : result -> Fascinating
	Input Number : 300  : result -> Not Fascinating
	Input Number : 100  : result -> Not Fascinating
	Input Number : 200  : result -> Not Fascinating
	Input Number : -10  : result -> Invalid Input
	-------------------------------------------------------------------
	*/
	
	public static int bonusQuestion (int [] arr) {
		if (arr.length < 2 || arr.length%2 != 0) {
			return -1;
		}
		int finalDifference = 0;
		for (int i=0; i<arr.length/2; i++) {
			finalDifference += (arr[i] - arr[arr.length-i-1]);
		}
		return Math.abs(finalDifference);
	}
	/*
	OUTPUT:
	bonusQuestion : ---------------------------------------------------------
	Input Array : {1,3,5,7}  : result -> 8
	Input Array : {0,0,0,0}  : result -> 0
	Input Array : {1}  : result -> -1
	Input Array : {-1,0,1}  : result -> -1
	Input Array : {}  : result -> -1
	---------------------------------------------------------------------
	*/
}
