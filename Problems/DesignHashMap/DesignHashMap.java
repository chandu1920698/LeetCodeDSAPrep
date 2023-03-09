/*
Class Name  : DesignHashMap
Description : This class consists of the solution for DesignHashMap.
Created Date: Mar 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/design-hashmap/description/
Modification Log: 
Date					    Name                                            Description
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added Class DesignHashMap
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added get 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added put 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added isExist 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added DesignHashMap 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added get1 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added put1 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added remove1 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added remove
--------------------------------------------------------------------------------------------------
706. Design HashMap
Easy
4K
357
Companies
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.
------------------------------------------------------------------------------------------------------
*/
package Problems.DesignHashMap;
import java.util.*;
public class DesignHashMap {

    List<Pair> map;
    int[] arrMap;
    public DesignHashMap() {
        /* 
         * TC : O(1)
         * SC : O(N)
        */
        map = new ArrayList<>();
        arrMap = new int[1000000 + 1];
        Arrays.fill(arrMap, -1);
    }

    
    public void put1(int key, int value) {
        /* 
         * TC : O(1)
         * SC : O(1)
        */
        arrMap[key] = value;
    }
    
    public int get1(int key) {
        /* 
         * TC : O(1)
         * SC : O(1)
        */
        return arrMap[key];
    }
    
    public void remove1(int key) {
        /* 
         * TC : O(1)
         * SC : O(1)
        */
        arrMap[key] = -1;
    }

    
    public void put(int key, int value) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int index = isExist(key);
        if(index == -1) {
            map.add(new Pair(key, value));
        } else {
            map.get(index).value = value;
        }
    }
    
    public int get(int key) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int index = isExist(key);
        if(index == -1) {
            return -1;
        }
        return map.get(index).value;
    }
    
    public void remove(int key) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int index = isExist(key);
        if(index == -1) {
            return;
        } else {
            map.remove(index);
        }
    }

    private int isExist(int key) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int index = 0;
        for(Pair pair : map) {
            if(pair.key == key) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
class Pair {
    int key;
    int value;
    
    Pair() {
        this.key = 0;
        this.value = 0;
    }

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}