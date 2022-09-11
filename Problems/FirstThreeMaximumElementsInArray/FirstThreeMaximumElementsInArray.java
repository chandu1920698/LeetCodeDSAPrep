/*
Class Name  : FirstThreeMaximumElementsInArray
Description : This class is used to find the First Three maximum elemets of the given array of integers.
Date        : Sep 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: NA

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added firstThreeMaximumElementsInArray 
*/
public class FirstThreeMaximumElementsInArray {
	public static void main(String[] args) {
		//Test Casaes
		int result[] = firstThreeMaximumElementsInArray(new int[]{1,2,3,4,5});
		System.out.println("Input Array : {1,2,3,4,5} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {1});
		System.out.println("Input Array : {1} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {1,2});
		System.out.println("Input Array : {1,2} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {1,1});
		System.out.println("Input Array : {1,1} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {-100,20,10000,400,50000});
		System.out.println("Input Array : {-100,20,10000,400,50000} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {4,4,4,4});
		System.out.println("Input Array : {4,4,4,4} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {-1,-2,-3,-4,-5});
		System.out.println("Input Array : {-1,-2,-3,-4,-5} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
		
		result = firstThreeMaximumElementsInArray(new int [] {0,0,0,0,0});
		System.out.println("Input Array : {0,0,0,0,0} -> First Max : " + result[0] + ", Second Max : " + result[1] + ", Third Max : " + result[2] ) ;
	}
	
	public static int[] firstThreeMaximumElementsInArray (int[] arr) {
		int max_1 = Integer.MIN_VALUE;
		int max_2 = Integer.MIN_VALUE;
		int max_3 = Integer.MIN_VALUE;
		
		if (arr.length < 3) {
			return new int[] {-1, -1, -1};
		}
		for (int val : arr) {
			if (max_1 < val) {
				max_3 = max_2;
				max_2 = max_1;
				max_1 = val;
			} else if (max_2 < val) {
				max_3 = max_2;
				max_2 = val;
			} else if (max_3 < val){
				max_3 = val;
			}
		}
		// for (int i=0; i<arr.length; i++) {
			// if (max_1 < arr[i]) {
				// max_2 = max_1;
				// max_1 = arr[i];
			// }else if (max_2 < arr[i]) {
				// max_2 = arr[i];
			// }
		// }
		// System.out.println("max_1 -> " + max_1);
		// System.out.println("max_2 -> " + max_2);
		// System.out.println("max_2 -> " + max_3);
		return new int[] {max_1, max_2,max_3};
	}
}

/*
OUTPUT:

Input Array : {1,2,3,4,5} -> First Max : 5, Second Max : 4, Third Max : 3
Input Array : {1} -> First Max : -1, Second Max : -1, Third Max : -1
Input Array : {1,2} -> First Max : -1, Second Max : -1, Third Max : -1
Input Array : {1,1} -> First Max : -1, Second Max : -1, Third Max : -1
Input Array : {-100,20,10000,400,50000} -> First Max : 50000, Second Max : 10000, Third Max : 400
Input Array : {4,4,4,4} -> First Max : 4, Second Max : 4, Third Max : 4
Input Array : {-1,-2,-3,-4,-5} -> First Max : -1, Second Max : -2, Third Max : -3
Input Array : {0,0,0,0,0} -> First Max : 0, Second Max : 0, Third Max : 0

*/