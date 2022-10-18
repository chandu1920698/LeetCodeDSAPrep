/*
Class Name  : IntersectionOfMultipleArrays
Description : This class consists of the solution for IntersectionOfMultipleArrays.
Date        : Oct 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/

Modification Log: 
Date					Name                                            Description
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class IntersectionOfMultipleArrays 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added intersectionUsingCollections 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added intersectionUsingElementCount
--------------------------------------------------------------------------------------------------
2248. Intersection of Multiple Arrays

Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, 
return the list of integers that are present in each array of nums sorted in ascending order.
 

Example 1:

Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
Output: [3,4]
Explanation: 
The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
Example 2:

Input: nums = [[1,2,3],[4,5,6]]
Output: []
Explanation: 
There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
 

Constraints:

1 <= nums.length <= 1000
1 <= sum(nums[i].length) <= 1000
1 <= nums[i][j] <= 1000
All the values of nums[i] are unique.
-------------------------------------------------------------------------------------------
*/
package Problems.IntersectionOfMultipleArrays;
import java.util.*;;
public class IntersectionOfMultipleArrays {
    public List<Integer> intersectionUsingCollections(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        
        int len = nums.length;
        
        for (int i = 0; i < nums[0].length; i++) {
            result.add(nums[0][i]);
        }
        
        for (int i = 1; i < len; i++) {
            
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums[i]) {
                tempList.add(num);
            }
            Iterator itr = result.iterator();   
            while (itr.hasNext())  {
                int data = (Integer)itr.next();   
                
                if(!tempList.isEmpty() && tempList.contains(data) ) {
                    continue;
                } else if (!tempList.isEmpty()) {
                    itr.remove();
                }
            }   
        }
        Collections.sort(result);
        return result;
    }
    
    public List<Integer> intersectionUsingElementCount(int[][] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        int[] count  = new int[1001];
        
        for(int[] arr : nums){
            for(int i : arr){
                count[i]++;
            }
        }
        
       for(int i=0;i<count.length;i++){
           if(count[i]==nums.length){
               ans.add(i);
           }
       }
        
        return ans;
    }
}