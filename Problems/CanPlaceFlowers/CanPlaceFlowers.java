/*
Class Name  : CanPlaceFlowers
Description : This class consists of the solution for CanPlaceFlowers.
Date        : Nov 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/can-place-flowers/

Modification Log: 
Date				Name                                            Description
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class CanPlaceFlowers 
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added canPlaceFlowers
--------------------------------------------------------------------------------------------------
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. 
However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
-------------------------------------------------------------------------------------------
*/
package Problems.CanPlaceFlowers;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == len - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                
                if (next == 0 && prev == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
                
                if (n == 0) return true; 
            }
        }
        
        return false;
    }

    /*
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] newFlowerBed = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newFlowerBed[i + 1] = flowerbed[i];
        }
        // System.out.println("Flower Bed New :"+ Arrays.toString(newFlowerBed) );
        return canPlaceFlowersHelper(newFlowerBed, 1, n);
    }
    
    public boolean canPlaceFlowersHelper(int[] flowerbed, int pos, int n) {
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if (pos == len - 1 ) {
            return false;
        }
        if (isSafe(flowerbed, pos)) {
            flowerbed[pos] = 1;
            if (canPlaceFlowersHelper(flowerbed, pos + 1, n - 1)) {
                return true;
            } else {
                flowerbed[pos] = 0;
            }            
        }
        canPlaceFlowersHelper(flowerbed, pos + 1, n);
        return false;
    }
    
    public boolean isSafe(int[] flowerbed, int pos) {        
        if (pos - 1  >= 0 && pos + 1 < flowerbed.length - 1 ) {
            if (flowerbed[pos - 1] == 0 && flowerbed[pos + 1] == 0 && flowerbed[pos] == 0) {
                return true;
            }
        }  
        System.out.println("Pos : " + pos);
        return false;
    }
    */
}