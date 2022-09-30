/*
Class Name  : FizzBuzz
Description : This class consists of the solution for FizzBuzz.
Date        : Sep 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/fizz-buzz/
Modification Log: 
Date					Name                                            Description
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class FizzBuzz 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added fizzBuzz 
Sep 17, 2022			Chandra Sekhar Reddy Muthumula					Added switch case logic 
--------------------------------------------------------------------------------------------------
412. Fizz Buzz

Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 

Example 1:
Input: n = 3
Output: ["1","2","Fizz"]

Example 2:
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 

Constraints:

1 <= n <= 10^4

*/
import java.util.*;;
class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> resultString = new ArrayList<String>();
        // Method 1
		/*
		TC 			: O(N)
		SC 			: O(1)
		Recommended : YES
		*/
        /*
        for (int i=1; i<=n; i++) {
            if (i%3==0 && i%5==0) {
                resultString.add("FizzBuzz");
            } else if(i%5 == 0) {
                resultString.add("Buzz");
            } else if(i%3 == 0) {
                resultString.add("Fizz");
            } else {
                resultString.add(Integer.toString(i));
            } 
        }
        */
        
        // Method 2
		/*
		TC 			: O(N)+O(N/3)+O(N/5)+O(N/15) 
		SC 			: O(1)
		Recommended : NO
		*/
        for (int i=0; i<n; i++) {
            resultString.add(Integer.toString(i+1));
        }
        System.out.println(resultString);
        for (int i=2; i<n; i+=3) {
            resultString.set(i, "Fizz");
        }
        System.out.println(resultString);
        for (int i=4; i<n; i+=5) {
            resultString.set(i,"Buzz");
        }
        System.out.println(resultString);
        for (int i=14; i<n; i+=15) {
            resultString.set(i, "FizzBuzz");
        }
        System.out.println(resultString);
		
		// Method 3
		/*
		TC 			: O(N)
		SC 			: O(1)
		Recommended : Yes
		*/
		
        for (int i=0; i<n; i++) {
            switch((i+1)%15) {
                case 0 : resultString.add( "FizzBuzz");
                         continue;
                case 3 : resultString.add( "Fizz");
                         continue;
                case 6 : resultString.add( "Fizz");
                         continue;
                case 9 : resultString.add( "Fizz");
                         continue;
                case 12 : resultString.add( "Fizz");
                         continue;
                case 5 : resultString.add( "Buzz");
                         continue;
                case 10 : resultString.add( "Buzz");
                         continue;
                default : resultString.add( Integer.toString(i+1));
                         continue;
            }
        }
        return  resultString;
    }
}

