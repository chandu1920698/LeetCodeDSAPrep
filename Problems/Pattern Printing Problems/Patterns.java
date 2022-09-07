/*
Class Name  : Patterns
Description : This class is used to print multiple patterns. Individual s/classes are written to print the patterns.
Author      : Chandra Sekhar Reddy Muthumula
Date        : Sep 4, 2022
Website Link: https://www.faceprep.in/c/pattern-programs-in-c/

Modification Log: 
Date				Name                                            Description
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added solidRectangle 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowRectangle 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added halfPyramid 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added invertedHalfPyramid 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowInvertedHalfPyramid 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added fullPyramid 
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added invertedFullPyramid
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added hollowFullPyramid
Sep 4, 2022			Chandra Sekhar Reddy Muthumula					Added halfPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added invertedHalfPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added hollowHalfPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added fullPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added hollowFullPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added hollowInvertedHalfPyramidNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added palindromeNumber
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added palindromeAlphabets
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added pyramidPalindromeNumbers
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added pyramidNumbersWithStars
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added solidDiamond
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added hollowDiamond
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added solidHalfDiamond
Sep 6, 2022			Chandra Sekhar Reddy Muthumula					Added solidLeftHalfDiamond
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added floydsTraingle
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added hollowDiamondInscribedInRectangle
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added pascalTriangle
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added butterflyPrintingPattern
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added diagonalAndSidesOfSquare
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added diagonalAndSidesOfParalellogram
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added diagonalAndSidesOfRhombus
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added leftArrowRightArrow
Sep 7, 2022			Chandra Sekhar Reddy Muthumula					Added solidThickDiamondHollow
*/
public class Patterns {
	public static void main(String args[]) {
		// solidRectangle(50, 10); solidRectangle(1, 2);
		// hollowRectangle(50, 10); hollowRectangle(10, 5);
		// halfPyramid(5); halfPyramid(10);
		// invertedHalfPyramid(10); invertedHalfPyramid(5);
		// hollowInvertedHalfPyramid(10);  hollowInvertedHalfPyramid(5);
		// fullPyramid(10); fullPyramid(5);
		// invertedFullPyramid(10); invertedFullPyramid(5);
		// hollowFullPyramid(5); hollowFullPyramid(10);
		// halfPyramidNumbers(10); halfPyramidNumbers(5);
		// invertedHalfPyramidNumbers(5); invertedHalfPyramidNumbers(10);
		// hollowHalfPyramidNumbers(5); hollowHalfPyramidNumbers(10);
		// fullPyramidNumbers(5); fullPyramidNumbers(10);
		// hollowFullPyramidNumbers(5); hollowFullPyramidNumbers(10);
		// hollowInvertedHalfPyramidNumbers(5); hollowInvertedHalfPyramidNumbers(10);
		// palindromeNumber(5); palindromeNumber(10);
		// palindromeAlphabets(5); palindromeAlphabets(10);
		// pyramidPalindromeNumbers(5); pyramidPalindromeNumbers(10);
		// pyramidNumbersWithStars(5); pyramidNumbersWithStars(10);
		// solidDiamond(5); solidDiamond(10);
		// hollowDiamond(5); hollowDiamond(10);
		// solidHalfDiamond(5); solidHalfDiamond(10);
		// solidLeftHalfDiamond(5); solidLeftHalfDiamond(10);
		// floydsTraingle(5); floydsTraingle(10);
		// hollowDiamondInscribedInRectangle(5); hollowDiamondInscribedInRectangle(10);
		// pascalTriangle(5); pascalTriangle(10);
		// butterflyPrintingPattern(5);butterflyPrintingPattern(15);
		// diagonalAndSidesOfSquare(10);diagonalAndSidesOfSquare(25);
		// diagonalAndSidesOfParalellogram(10);diagonalAndSidesOfParalellogram(25);
		// diagonalAndSidesOfRhombus(10);diagonalAndSidesOfRhombus(25);
		// leftArrowRightArrow(10);leftArrowRightArrow(11); 
		solidThickDiamondHollow(5);solidThickDiamondHollow(10);
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
			for (int j = 0;  i+j < N; j++ ) {
				System.out.print("  ");
			}
			int k;
			for (k = i + 1; k <= 2 * (i + 1) -1 ; k++) {
				System.out.print(k + " ");
			}
			for (k-=2; k >= (i + 1); k--) {
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
			2 3 2
		  3 4 5 4 3
		4 5 6 7 6 5 4
	  5 6 7 8 9 8 7 6 5
	----------------------------------------------------------
	*/
	
	public static void hollowFullPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for (int j = 0;  i+j < N; j++ ) {
				System.out.print(" ");
			}
			for (int j = 0;  j <= i; j++ ) {
				if( (j == 0) || (j == i) || i == N -1 ) {
					System.out.print(j + 1 + " ");
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
	 1 2 3 4 5
	----------------------------------------------------------
	*/
	
	public static void hollowInvertedHalfPyramidNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for (int j = 0;  i+j < N; j++ ) {
				if ((i == 0) || (i == N - 1) || (j == 0) || ( i + j == N - 1)) {
					System.out.print( i + j + 1 + " ");
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
	1 2 3 4 5
	2     5
	3   5
	4 5
	5
	----------------------------------------------------------
	*/
	
	public static void palindromeNumber (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j = 0; j < (i + 1); j++) {
				System.out.print(j + 1 + " " );
			} 
			for (j-=2; j >= 0; j--) {
				System.out.print(j + 1 + " " );
			}
				
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}	
	/*
	OUTPUT:
	----------------------------------------------------------
	1
	1 2 1
	1 2 3 2 1
	1 2 3 4 3 2 1
	1 2 3 4 5 4 3 2 1
	----------------------------------------------------------
	*/
	
	public static void palindromeAlphabets (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j = 0; j < (i + 1); j++) {
				System.out.print((char)(j + 1 + 64) + " " );
			} 
			for (j-=2; j >= 0; j--) {
				System.out.print((char)(j + 1 + 64) + " " );
			}
				
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}	
	/*
	OUTPUT:
	----------------------------------------------------------
	A
	A B A
	A B C B A
	A B C D C B A
	A B C D E D C B A
	----------------------------------------------------------
	*/
	
	public static void pyramidPalindromeNumbers (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for (int j = 0;  i+j < N; j++ ) {
				System.out.print("  ");
			}
			int k;
			for (k = 0; k < (i + 1); k++) {
				System.out.print(k + 1 + " ");
			}
			for (k-=2; k >= 0; k--) {
				System.out.print(k + 1 + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
			  1
			1 2 1
		  1 2 3 2 1
		1 2 3 4 3 2 1
	  1 2 3 4 5 4 3 2 1
	----------------------------------------------------------
	*/
	
	public static void pyramidNumbersWithStars (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; i+j<N; j++) {
				System.out.print('*');
			}
			for (int k=0; k<=i; k++) {
				System.out.print(k+1 + "*");
			}
			for (int j=0; i+j<N; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	} 
	/*
	OUTPUT:
	----------------------------------------------------------
	*****1******
	****1*2*****
	***1*2*3****
	**1*2*3*4***
	*1*2*3*4*5**
	----------------------------------------------------------
	*/
	
	public static void solidDiamond (int N) {
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
	*/
	
	public static void hollowDiamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<=i; j++){
				if (j==0 || j==i) {
					System.out.print("* "); 
				} else {
					System.out.print("  "); 
				}
			}
			System.out.println();
		}
		for(int i=1; i<N; i++){
			int j;
			for (j=0; j<=i; j++) {
				System.out.print(' ');
			}
			for(j=0; i+j<N; j++){
				if (j==0 || i+j==N-1) {
					System.out.print("* "); 
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
		 *
		* *
	   *   *
	  *     *
	 *       *
	  *     *
	   *   *
		* *
		 *
	----------------------------------------------------------
	*/
	
	public static void solidHalfDiamond (int N) {
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
	*
	**
	***
	****
	*****
	****
	***
	**
	*
	----------------------------------------------------------
	*/
	
	public static void solidLeftHalfDiamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for(j=0; i+j<N-1; j++){
				System.out.print(" ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++){
			int j;
			for(j=0; j<=i; j++){
				System.out.print(" ");
			}
			for(int k=N-j; k>0; k--) {
				System.out.print("*");
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
	 ****
	  ***
	   **
		*

	----------------------------------------------------------
	*/
	
	public static void floydsTraingle (int N) {
		System.out.println("----------------------------------------------------------");
		int count = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print(++count + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	1
	2 3
	4 5 6
	7 8 9 10
	11 12 13 14 15
	----------------------------------------------------------
	*/
	
	public static void hollowDiamondInscribedInRectangle (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for (j=0; i+j<N; j++) {
				System.out.print('*');
			}
			for(j=0; j<=i; j++){
				System.out.print("  ");           // Prints the starts here
				//System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			for(j=0; i+j<N; j++){
				System.out.print("*");           // Prints the starts here
				//System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			System.out.println();
		}
		for(int i=1; i<N; i++){
			int j;
			for (j=0; j<=i; j++) {
				System.out.print('*');
			}
			for(j=0; i+j<N; j++){
				System.out.print("  ");           // Prints the starts here
				//System.out.print(j + 1 + " " );  	// Prints the numbers here
			}
			
			for (j=0; j<=i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	*****  *****
	****    ****
	***      ***
	**        **
	*          *
	**        **
	***      ***
	****    ****
	*****  *****
	----------------------------------------------------------
	*/
	
	public static void pascalTriangle (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; i+j<N; j++) {
				System.out.print(" ");
			}
			int temp = 1;
			for (int k=0; k<=i; k++) {
				System.out.print(temp + " ");
				temp = temp*(i-k)/(k+1);
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
			  1
			 1 1
			1 2 1
		   1 3 3 1
		  1 4 6 4 1
		 1 5 10 10 5 1
		1 6 15 20 15 6 1
	   1 7 21 35 35 21 7 1
	  1 8 28 56 70 56 28 8 1
	 1 9 36 84 126 126 84 36 9 1
	----------------------------------------------------------
	*/
	
	public static void butterflyPrintingPattern (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for(j=0; j<=i; j++){
				System.out.print("*");           // Prints the starts here
			}
			for (j=0; i+j<N-1; j++) {
				System.out.print(' ');
			}
			for (j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for(j=0; j<=i; j++){
				System.out.print("*");           // Prints the starts here
			}
			System.out.println();
		}
		for(int i=1; i<N; i++){
			int j;
			for(j=0; i+j<N; j++){
				System.out.print("*");           // Prints the starts here
			}
			for (j=0; j<=2*i; j++) {
				System.out.print(' ');
			}
			for(j=0; i+j<N; j++){
				System.out.print("*");           // Prints the starts here
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
	*         *
	**       **
	***     ***
	****   ****
	***** *****
	****   ****
	***     ***
	**       **
	*         *
	----------------------------------------------------------
	*/
	
	public static void diagonalAndSidesOfSquare (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(i==j || i==0 || j==0 || i==N-1 || j==N-1 || i+j==N-1) {
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
	**********
	**      **
	* *    * *
	*  *  *  *
	*   **   *
	*   **   *
	*  *  *  *
	* *    * *
	**      **
	**********
	----------------------------------------------------------
	*/
	
	public static void diagonalAndSidesOfParalellogram (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; i+j<N; j++) {
				System.out.print(' ');
			}
			for (int j=0; j<N; j++) {
				if(i==j || i==0 || j==0 || i==N-1 || j==N-1 || i+j==N-1) {
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
			  **********
			 **      **
			* *    * *
		   *  *  *  *
		  *   **   *
		 *   **   *
		*  *  *  *
	   * *    * *
	  **      **
	 **********
	----------------------------------------------------------
	*/
	
	public static void diagonalAndSidesOfRhombus (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(i==(N-1)/2 || j==(N-1)/2 || i+j==(N-1)/2 || (i-j)==((N-1)/2) || (j-i)==((N-1)/2) ||  i+j==(N/2)*3) {
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
		 *
		***
	   * * *
	  *  *  *
	 *   *   *
	***********
	 *   *   *
	  *  *  *
	   * * *
		***
		 *
	----------------------------------------------------------
	*/
	
	public static void leftArrowRightArrow (int N) {
		System.out.println("----------------------------------------------------------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(i==(N-1)/2 || (j-i)==((N-1)/2) ||  i+j==(N/2)*3) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.print("   ");
			for (int j=0; j<N; j++) {
				if(i==(N-1)/2 || i+j==(N-1)/2 || (i-j)==((N-1)/2)) {
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
		 *             *
		  *           *
		   *         *
			*       *
			 *     *
	***********   ***********
			 *     *
			*       *
		   *         *
		  *           *
		 *             *
	----------------------------------------------------------
	*/
	
	public static void solidThickDiamondHollow (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			int j;
			for(j=0; i+j<N; j++){
				System.out.print("    ");
			}
			for(j=0; j<=i; j++) {
				System.out.print("* ");
			}
			for(j=0; j<=i; j++){
				System.out.print("    ");
			}
			for(j=0; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++){
			int j;
			for(j=0; j<=i; j++){
				System.out.print("    ");
			}
			for(j=0; i+j<N; j++) {
				System.out.print("* ");
			}
			for(j=0; i+j<N; j++){
				System.out.print("    ");
			}
			for(j=0; i+j<N; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------------------------");
	}
	/*
	OUTPUT:
	----------------------------------------------------------
											*     *
										* *         * *
									* * *             * * *
								* * * *                 * * * *
							* * * * *                     * * * * *
						* * * * * *                         * * * * * *
					* * * * * * *                             * * * * * * *
				* * * * * * * *                                 * * * * * * * *
			* * * * * * * * *                                     * * * * * * * * *
		* * * * * * * * * *                                         * * * * * * * * * *
		* * * * * * * * * *                                         * * * * * * * * * *
			* * * * * * * * *                                     * * * * * * * * *
				* * * * * * * *                                 * * * * * * * *
					* * * * * * *                             * * * * * * *
						* * * * * *                         * * * * * *
							* * * * *                     * * * * *
								* * * *                 * * * *
									* * *             * * *
										* *         * *
											*     *
	----------------------------------------------------------
	*/
}



