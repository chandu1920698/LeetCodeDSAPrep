/*
Class Name  : Patterns
Description : This class is used to print multiple patterns. Individual methods/classes are written to print the patterns.
Author      : Chandra Sekhar Reddy Muthumula
Date        : Sep 4, 2022
Website Link: https://www.faceprep.in/c/pattern-programs-in-c/

Modification Log: 
Date				Name                                            Description
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added solidRectangle method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowRectangle method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added halfPyramid method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added invertedHalfPyramid method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowInvertedHalfPyramid method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added fullPyramid method
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added invertedFullPyramid
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowFullPyramid
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added halfPyramidNumbers
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added invertedHalfPyramidNumbers
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowHalfPyramidNumbers
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added fullPyramidNumbers
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added

*/
public class Patterns {
	public static void main(String args[]) {
		// solidRectangle(50, 10);
		// solidRectangle(1, 2);
		// hollowRectangle(50, 10);
		// hollowRectangle(10, 5);
		// halfPyramid(5);
		// halfPyramid(10);
		// invertedHalfPyramid(10);
		// invertedHalfPyramid(5);
		// hollowInvertedHalfPyramid(10);
		// hollowInvertedHalfPyramid(5);
		// fullPyramid(10);
		// fullPyramid(5);
		// invertedFullPyramid(10);
		// invertedFullPyramid(5);
		// hollowFullPyramid(5);
		// hollowFullPyramid(10);
		// halfPyramidNumbers(10);
		// halfPyramidNumbers(5);
		// invertedHalfPyramidNumbers(5);
		// invertedHalfPyramidNumbers(10);
		// hollowHalfPyramidNumbers(5);
		// hollowHalfPyramidNumbers(10);
		fullPyramidNumbers(5);
		fullPyramidNumbers(10);
		// rightHalfDiamond(5);
		// rightHalfDiamond(10);
		// leftHalfDiamond(5);
		// leftHalfDiamond(10);
		// leftHalfDiamondRightHollow(5);
		// leftHalfDiamondRightHollow(10);
		// pyramid(5);
		// invertedPyramid(5);
		// pyramid(10);
		// invertedPyramid(10);
		// diamond(5);
		// diamond(10);
	}
	
	public static void solidRectangle (int length, int breadth) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<breadth; i++) {
			for (int j=0; j<length; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	**************************************************
	----------------------------------------------------------
	*/
	
	public static void hollowRectangle (int length, int breadth) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<breadth; i++) {
			for (int j=0; j<length; j++) {
				if((i == 0) || (i == breadth - 1) || (i != 0 && (j == 0 || j == length - 1))) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	**************************************************
	*                                                *
	*                                                *
	*                                                *
	*                                                *
	*                                                *
	*                                                *
	*                                                *
	*                                                *
	**************************************************
	----------------------------------------------------------
	*/
	
	public static void halfPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
			System.out.print('*');           // Prints the starts here
			//System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	*
	**
	***
	****
	*****
	----------------------------------------------------------
	*/
	
	public static void invertedHalfPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; i+j < N; j++){
			System.out.print('*');         // Prints the starts here
			//System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	**********
	*********
	********
	*******
	******
	*****
	****
	***
	**
	*
	----------------------------------------------------------
	*/
	
	public static void hollowInvertedHalfPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; i+j < N; j++){
				if ( (i == 0) || (i == N -1) || (j == 0 || j == N - i - 1) ) {
					System.out.print('*');         // Prints the starts here
					//System.out.print(j + 1 + " " );  // Prints the numbers here
				} else {
					System.out.print(' ');         
				}
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	**********
	*       *
	*      *
	*     *
	*    *
	*   *
	*  *
	* *
	**
	*
	----------------------------------------------------------
	*/
	
	public static void fullPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<=i; j++){
				System.out.print("* ");           // Prints the starts here
			//System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
			  *
			 * *
			* * *
		   * * * *
		  * * * * *
		 * * * * * *
		* * * * * * *
	   * * * * * * * *
	  * * * * * * * * *
	 * * * * * * * * * *
	----------------------------------------------------------
	*/
	
	public static void invertedFullPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; j<=i; j++) {
				System.out.print(' ');
			}
			for(j=0; i+j<N; j++){
				System.out.print("* ");           // Prints the starts here
			//System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	 * * * * * * * * * *
	  * * * * * * * * *
	   * * * * * * * *
		* * * * * * *
		 * * * * * *
		  * * * * *
		   * * * *
			* * *
			 * *
			  *
	----------------------------------------------------------
	*/
	
	public static void hollowFullPyramid (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<= 2 * i; j++){
				if ( (i == 0) || (i == N -1 ) || (j == 0 || (j  == 2 * i) ) ) {
					System.out.print("*");           // Prints the starts here
					//System.out.print(j + 1 + " " );  // Prints the numbers here
				} else {
					System.out.print(' ');      
				}
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
			  *
			 * *
			*   *
		   *     *
		  *       *
		 *         *
		*           *
	   *             *
	  *               *
	 *******************
	----------------------------------------------------------
	*/
	
	public static void halfPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
			System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	1
	1 2
	1 2 3
	1 2 3 4
	1 2 3 4 5
	----------------------------------------------------------
	*/
	
	public static void invertedHalfPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; i+j < N; j++){
			System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	1 2 3 4 5
	1 2 3 4
	1 2 3
	1 2
	1
	----------------------------------------------------------
	*/
	
	public static void hollowHalfPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
				if ( (i == 0) || ( i == N -1 ) || (j == 0 || j == i) ) {
					System.out.print(j + 1 + " " );  // Prints the numbers here
				} else {
					System.out.print("  ");  
				}
				
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	1
	1 2
	1   3
	1     4
	1       5
	1         6
	1           7
	1             8
	1               9
	1 2 3 4 5 6 7 8 9 10
	----------------------------------------------------------
	*/
	
	public static void fullPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<=i; j++){
				System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	
	public static void rightHalfDiamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
			System.out.print('*');           // Prints the starts here
			//System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
		
		for(int i=1; i<N; i++){
			for(int j=0; i+j < N; j++){
			//System.out.print('*');         // Prints the starts here
			System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
	}
	
	public static void leftHalfDiamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for(j=0; i+j<N-1; j++){
				System.out.print("  ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++){
			int j;
			for(j=0; j<=i; j++){
				System.out.print("  ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
					  1
					2 1
				  3 2 1
				4 3 2 1
			  5 4 3 2 1
			6 5 4 3 2 1
		  7 6 5 4 3 2 1
		8 7 6 5 4 3 2 1
	  9 8 7 6 5 4 3 2 1
	10 9 8 7 6 5 4 3 2 1
	  9 8 7 6 5 4 3 2 1
		8 7 6 5 4 3 2 1
		  7 6 5 4 3 2 1
			6 5 4 3 2 1
			  5 4 3 2 1
				4 3 2 1
				  3 2 1
					2 1
					  1

	----------------------------------------------------------
	*/
	
	public static void leftHalfDiamondRightHollow (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for(j=0; i+j<N-1; j++){
				System.out.print("    ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++){
			int j;
			for(j=0; j<=i; j++){
				System.out.print("    ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
		Output:
		
	----------------------------------------------------------
										1
									2 1
								3 2 1
							4 3 2 1
						5 4 3 2 1
					6 5 4 3 2 1
				7 6 5 4 3 2 1
			8 7 6 5 4 3 2 1
		9 8 7 6 5 4 3 2 1
	10 9 8 7 6 5 4 3 2 1
		9 8 7 6 5 4 3 2 1
			8 7 6 5 4 3 2 1
				7 6 5 4 3 2 1
					6 5 4 3 2 1
						5 4 3 2 1
							4 3 2 1
								3 2 1
									2 1
										1

	----------------------------------------------------------
	*/
	
	
	
	
	public static void diamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<=i; j++){
				//System.out.print("* ");           // Prints the starts here
				System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			System.out.println();
		}
		for(int i=1; i<N; i++){
			int j;
			for (j=0; j<=i; j++) {
				System.out.print(' ');
			}
			for(j=0; i+j<N; j++){
				//System.out.print("* ");           // Prints the starts here
				System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
				  *
				 * *
				* * *
			   * * * *
			  * * * * *
			 * * * * * *
			* * * * * * *
		   * * * * * * * *
		  * * * * * * * * *
		 * * * * * * * * * *
		  * * * * * * * * *
		   * * * * * * * *
			* * * * * * *
			 * * * * * *
			  * * * * *
			   * * * *
				* * *
				 * *
				  *
	----------------------------------------------------------
	----------------------------------------------------------
			  1
			 1 2
			1 2 3
		   1 2 3 4
		  1 2 3 4 5
		 1 2 3 4 5 6
		1 2 3 4 5 6 7
	   1 2 3 4 5 6 7 8
	  1 2 3 4 5 6 7 8 9
	 1 2 3 4 5 6 7 8 9 10
	  1 2 3 4 5 6 7 8 9
	   1 2 3 4 5 6 7 8
		1 2 3 4 5 6 7
		 1 2 3 4 5 6
		  1 2 3 4 5
		   1 2 3 4
			1 2 3
			 1 2
			  1
	----------------------------------------------------------
	*/
}

/*class rectangularPattern {
	protected void printRectangularPattern (int length, int breadth) {
		for(int i=0; i<breadth; i++) {
			for (int j=0; j<length; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}*/


