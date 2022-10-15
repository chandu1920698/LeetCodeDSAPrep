/*
Class Name  : KokoEatingBananas
Description : This class consists of the solution for KokoEatingBananas.
Date        : Oct 15, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/koko-eating-bananas/

Modification Log: 
Date					Name                                            Description
Oct 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class KokoEatingBananas 
Oct 15, 2022			Chandra Sekhar Reddy Muthumula					Added minEatingSpeed
--------------------------------------------------------------------------------------------------
875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. 
Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
-------------------------------------------------------------------------------------------
*/
package Problems.KokoEatingBananas;

import java.io.ObjectInputFilter.Status;
import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println("Rate : " + minEatingSpeed(new int[] {3,6,7,11,8}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        
        int left = 1;
        int right = 1000000000 + 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            int hours = 0;
            
            for(int pile : piles){
                int div = pile / mid;
                hours += div;
                if(pile % mid != 0) hours++;
            }
            
            if(hours <= h) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }  

    // public int minEatingSpeed(int[] piles, int h) {
    //     int len = piles.length;
        
    //     long avgRate = 0;
    //     for (int i=0; i<len; i++) {
    //         avgRate += piles[i];
    //     }
        
    //     avgRate /= h;
        
    //     System.out.println("Avg rate :" + avgRate);
    //     // If the len == 1 then the arte rate is piles[0] / h
        
    //     if (len == 1) {
    //         if (piles[0] % h == 0 ) {
    //             return piles[0] / h;
    //         } else {
    //             return (piles[0]/h) + 1;
    //         }
    //     }
        
    //     // Sorting piles
    //     Arrays.sort(piles);
        
    //     // Taking the inital rate as piles[0] which is minimum
    //     for (int rate = (int)avgRate; rate <= piles[len - 1]; rate++) {
    //         int tempHours = 0;
            
    //         for(int j = len - 1; j >= 0; j--) {
                
    //             // Update the hours taken 
    //             if(piles[j] % rate == 0) {
    //                 tempHours += piles[j] / rate;
    //             } else {
    //                 tempHours += ((piles[j]/rate) + 1);
    //             }
                
    //             // Check if the hours taken is greater than given max hours
    //             // If yes then it is not the required banana eating rate
                
    //             if(tempHours > h) {
    //                 break;
    //             }
    //         }   
            
    //         // Check if the hours taken is greater than given max hours
    //         // If yes then it is not the required banana eating rate

    //         if(tempHours > h) {
    //             continue;
    //         } else {
    //             return rate;
    //         }
    //     }
    //     return piles[len - 1];
    // }
}