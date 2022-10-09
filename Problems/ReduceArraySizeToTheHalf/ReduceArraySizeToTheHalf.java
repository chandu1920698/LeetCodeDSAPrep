/*
Class Name  : ReduceArraySizeToTheHalf
Description : This class consists of the solution for ReduceArraySizeToTheHalf.
Date        : Oct 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/reduce-array-size-to-the-half/

Modification Log: 
Date				Name                                            Description
Oct 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class ReduceArraySizeToTheHalf 
Oct 9, 2022			Chandra Sekhar Reddy Muthumula					Added minSetSize
--------------------------------------------------------------------------------------------------
1338. Reduce Array Size to The Half

You are given an integer array arr. You can choose a set of integers 
and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 
(i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5]
 which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 

Constraints:

2 <= arr.length <= 105
arr.length is even.
1 <= arr[i] <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.ReduceArraySizeToTheHalf;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        
        int len = arr.length;
        int half = len/2;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<len; i++) {
            // if (!(map.containsKey(arr[i]))) {
            //     map.put(arr[i], 0);
            // }
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        // System.out.println(map);
        if(map.size() == 1 || map.size() ==  2) {
            return 1;
        }
        int[] freq = new int[map.size()];
        int index = 0;
        
        // for(Integer item : map.keySet()) {
        //     freq[index++] = (int)map.get(item);
        // }
        
        for(Integer item : map.values()) {
            freq[index++] = item;
        }
        
        Arrays.sort(freq);
        // System.out.println("Freq : " + Arrays.toString(freq));
        int count = 0;
        int freqLength = freq.length;
        int removed = 0;
        for (int i = freqLength - 1; i>=0; i--) {
            if(removed < half){
                removed += freq[i];
                count++;
            }  
        }
        
        return count;
    }
}