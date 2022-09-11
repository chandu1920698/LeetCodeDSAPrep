/*
Class Name  : FirstTwoMaximumElementsInArray
Description : This class is used to find the First two maximum elemets of the given array of integers.
Date        : Sep 11, 2022
Website Link: NA

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added firstTwoMaximumElementsInArray 
*/
public class FirstTwoMaximumElementsInArray {
	public static void main(String[] args) {
		//Test Casaes
		int result[] = firstTwoMaximumElementsInArray(new int[]{ 1, 2, 3 });
		System.out.println("Input Array : {1,2,3,4,5} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {1});
		System.out.println("Input Array : {1} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {1,2});
		System.out.println("Input Array : {1,2} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {1,1});
		System.out.println("Input Array : {1,1} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {-100,20,10000,400,50000});
		System.out.println("Input Array : {-100,20,10000,400,50000} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {4,4,4,4});
		System.out.println("Input Array : {4,4,4,4} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {-1,-2,-3,-4,-5});
		System.out.println("Input Array : {-1,-2,-3,-4,-5} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
		
		result = firstTwoMaximumElementsInArray(new int [] {0,0,0,0,0});
		System.out.println("Input Array : {0,0,0,0,0} -> First Max : " + result[0] + " Second Max : " + result[1] ) ;
	}
	
	public static int[] firstTwoMaximumElementsInArray (int[] arr) {
		int max_1 = Integer.MIN_VALUE;
		int max_2 = Integer.MIN_VALUE;
		
		if (arr.length < 2) {
			return new int[] {-1,-1};
		}
		// for (int val : arr) {
			// if (max_1 < val) {
				// max_2 = max_1;
				// max_1 = val;
			// }
			// if (max_2 < val) {
				// max_2 = val;
			// }
		// }
		for (int i=0; i<arr.length; i++) {
			if (max_1 < arr[i]) {
				max_2 = max_1;
				max_1 = arr[i];
			}else if (max_2 < arr[i]) {
				max_2 = arr[i];
			}
		}
		//System.out.println("max_1 -> " + max_1);
		//System.out.println("max_2 -> " + max_2);
		return new int[] {max_1, max_2};
	}
}

/*
OUTPUT:

Input Array : {1,2,3,4,5} -> First Max : 3 Second Max : 2
Input Array : {1} -> First Max : -1 Second Max : -1
Input Array : {1,2} -> First Max : 2 Second Max : 1
Input Array : {1,1} -> First Max : 1 Second Max : 1
Input Array : {-100,20,10000,400,50000} -> First Max : 50000 Second Max : 10000
Input Array : {4,4,4,4} -> First Max : 4 Second Max : 4
Input Array : {-1,-2,-3,-4,-5} -> First Max : -1 Second Max : -2
Input Array : {0,0,0,0,0} -> First Max : 0 Second Max : 0

*/