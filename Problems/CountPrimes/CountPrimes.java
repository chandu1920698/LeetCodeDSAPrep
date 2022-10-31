/*
Class Name  : CountPrimes
Description : This class consists of the solution for CountPrimes.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/count-primes/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class CountPrimes 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added countPrimes
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added countPrimesVeryEfficient
--------------------------------------------------------------------------------------------------
204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
-------------------------------------------------------------------------------------------
*/
package Problems.CountPrimes;

public class CountPrimes {
    public int countPrimes(int n) {
        /*
         * TC : O(Log Log N)
         * SC : O(N)
        */
        if(n == 0 || n == 1) return 0;
        boolean[] prime = new boolean[n];
        for(int i = 2; i < n; i++) {
            prime[i] = true;
        }
        // System.out.println("Prime : " + Arrays.toString(prime));
        for (int i = 2; i * i < n; i++) {
            if(prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                    // count--;
                }
            }
        }
        // System.out.println("Prime : " + Arrays.toString(prime));
        int count = 0;
        for (boolean item : prime) {
            if(item) count++; 
        }
        
        return count;
    }

    public int countPrimesVeryEfficient(int n) {
        /*
         * TC : O(Log Log N)
         * SC : O(N)
        */
        if (n < 3) return 0;
        int count = n / 2;
        boolean[] primeTracker = new boolean[n];
        
        for (int i = 3; i * i < n; i += 2) {
            if (primeTracker[i]) continue; // i ir i + 1 both does the work
            
            for (int j = i * i; j < n; j += i * 2) {
                if (! primeTracker[j]) {
                    count--;
                    primeTracker[j] = true;
                } 
            }
        }
        return count;
    }
}