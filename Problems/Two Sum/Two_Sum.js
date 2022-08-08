/*
Two Sum
Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9Output: [0,1]Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6Output: [0,1]
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity
*/

/*
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let arraylength = nums.length;
    if(2 <= arraylength <= Math.pow(10,4) && -1 * Math.pow(10,9) <= target <= Math.pow(10,9)) {
        let hashMapData =  new Map();
        for(let index = 0; index < arraylength; index++) {
            // for(let index2 = index1 + 1; index2 < arraylength; index2++) {
            //     if(nums[index1] + nums[index2] == target && -1 * Math.pow(10,9) <= nums[index1] <= Math.pow(10,9)){
            //        return new Array(index1, index2);
            //     }
            // }
            if(-1 * Math.pow(10,9) <= nums[index] <= Math.pow(10,9)) {
                let valueToBeSearched = target - nums[index];
                
                /*
                ===========================================
                Implementing binary search
                Start searching from the next element of the array i.e from index + 1
                This will not work for all the test cases as the Binary search algorithm needs the sorted list of elements
                ===========================================
                */
                // for (let index2 = index + 1; index2 < arraylength; index2++ ){
                //     let lowerIndex = index2;
                //     let higherIndex = arraylength - 1;
                //     while (lowerIndex <= higherIndex) {
                //         let midIndex = Math.floor((lowerIndex + higherIndex)/2);
                //         console.log(lowerIndex,higherIndex, midIndex);
                //         if (nums[midIndex] < valueToBeSearched) {
                //             lowerIndex = midIndex + 1; 
                //         } else if(nums[midIndex] > valueToBeSearched) {
                //             higherIndex = midIndex - 1;   
                //         } else {
                //             return new Array(index, midIndex);
                //         }
                //     }
                // }
                
                /*
                ===========================================
                We are usig Hash map here
                This reduces the time complexity to a greater extent
                ===========================================
                */
                
                if (hashMapData.has(nums[index])) {
                    ///console.log('Has value');
                    return [hashMapData.get(nums[index]), index];
                } else {
                    hashMapData.set(valueToBeSearched, index);
                    //console.log('Has not value');
                }
                //console.log(hashMapData);
            }
        }
    }
};