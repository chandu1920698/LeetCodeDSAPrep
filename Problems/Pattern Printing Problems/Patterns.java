/*
Class Name  : Patterns
Description : This class is used to print multiple patterns. Individual methods/classes are written to print the patterns.
Author      : Chandra Sekhar Reddy Muthumula
Date        : Sep 4, 2022


Modification Log: 
Date				Name                                            Description
 
*/
public class Patterns {
	public static void main(String args[]) {
		System.out.println("Hi");
		// printRectangularPattern(5, 10);
		// printRectangularPattern(1,2);
		// increasingTriangle(5);
		// increasingTriangle(10);
		// decreasingTriangle(10);
		// decreasingTriangle(5);
		// rightHalfDiamond(5);
		// rightHalfDiamond(10);
		leftHalfDiamond(5);
		leftHalfDiamond(10);
		leftHalfDiamondRightHollow(5);
		leftHalfDiamondRightHollow(10);
	}
	
	public static void printRectangularPattern (int length, int breadth) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<breadth; i++) {
			for (int j=0; j<length; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	public static void increasingTriangle (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
			//System.out.print('*');           // Prints the starts here
			System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
	}
	
	public static void decreasingTriangle (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; i+j < N; j++){
			//System.out.print('*');         // Prints the starts here
			System.out.print(j + 1 + " " );  // Prints the numbers here
			}
			System.out.println();
		}
	}
	
	public static void rightHalfDiamond (int N) {
		System.out.println("----------------------------------------------------------");
		for(int i=0; i<N; i++){
			for(int j=0; j<=i; j++){
			//System.out.print('*');           // Prints the starts here
			System.out.print(j + 1 + " " );  // Prints the numbers here
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


