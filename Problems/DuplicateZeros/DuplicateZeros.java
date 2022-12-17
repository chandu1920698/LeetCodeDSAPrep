/*
Class Name  : DuplicateZeros
Description : This class consists of the solution for DuplicateZeros.
Created Date: Sep 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/duplicate-zeros/
Modification Log: 
Date					Name                                            Description
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class DuplicateZeros 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added duplicateZeros
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added duplicateZerosBruteForce
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added duplicateZerosBruteForceTCCompromised
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added shiftArray
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added duplicateZerosQueueApproach
--------------------------------------------------------------------------------------------------
1089. Duplicate Zeros
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written. 
Do the above modifications to the input array in place and do not return anything.

Example 1:
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:
Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 9
------------------------------------------------------------------------------------------------------
*/

import java.util.*;

class DuplicateZeros {
    // public void duplicateZeros(int[] arr) {
    // int arrLength = arr.length;
    // int index = 0;
    // for (int i=0; i<arrLength-1; i++) {
    // if ( arr[i] == 0) {
    // shiftTheElements(arr, i+1);
    // arr[++i] = 0;
    // }

    // // System.out.println("arr -> " + Arrays.toString(arr));
    // }
    // }

    // public void shiftTheElements(int[] arr, int start){
    // for (int i=arr.length-1;i>start; i--) {
    // arr[i] = arr[i-1];
    // }
    // }

    /*
     * O(n) runtime
     * O(1) space
     */
    public void duplicateZeros(int[] A) {

        int n = A.length, count = 0;

        for (int num : A) {
            if (num == 0) {
                count++;
            }
        }

        int i = n - 1;
        int write = n + count - 1;

        while (i >= 0 && write >= 0) {

            if (A[i] != 0) { // Non-zero, just write it in
                if (write < n)
                    A[write] = A[i];

            } else { // Zero found, write it in twice if we can
                if (write < n)
                    A[write] = A[i];
                write--;
                if (write < n)
                    A[write] = A[i];
            }

            i--;
            write--;
        }
    }

    public void duplicateZerosBruteForce(int[] arr) {
        /*
         * TC : O(2*N)
         * SC : O(N)
         * Space complexity is compromised
         */
        int len = arr.length;

        int[] newArr = new int[len];
        int index = 0;
        for (int i = 0; i < len && index < len; i++) {
            if (arr[i] == 0) {
                newArr[index++] = arr[i];
                if (index < len) {
                    newArr[index++] = arr[i];
                }
            } else {
                newArr[index++] = arr[i];
            }
        }

        for (int i = 0; i < len; i++) {
            arr[i] = newArr[i];
        }
    }

    public void duplicateZerosBruteForceTCCompromised(int[] arr) {
        /*
         * TC : O(N^2)
         * SC : O(1)
         * Brute force Time Complexity compromised
         */
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                if (i + 1 < len) {
                    shiftArray(arr, i + 1);
                    arr[++i] = 0;
                }
            }
        }
    }

    private void shiftArray(int[] arr, int index) {
        int len = arr.length;
        if (index < len) {
            for (int i = len - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
        }
        // System.out.println(Arrays.toString(arr));
    }

    public void duplicateZerosQueueApproach(int[] arr) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(arr[i]);
            }
            arr[i] = queue.poll();
        }
    }
}
