/*
Class Name  : TimeBasedKeyValueStore
Description : This class consists of the solution for TimeBasedKeyValueStore.
Date        : Nov 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/time-based-key-value-store/description/

Modification Log: 
Date				    Name                                            Description
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class TimeBasedKeyValueStore 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor TimeBasedKeyValueStore 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class Value_Class 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor Value_Class 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Value_Class 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added get
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added set
--------------------------------------------------------------------------------------------------
981. Time Based Key-Value Store
Medium
3.6K
342
Companies
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 

Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
 

Constraints:

1 <= key.length, value.length <= 100
key and value consist of lowercase English letters and digits.
1 <= timestamp <= 107
All the timestamps timestamp of set are strictly increasing.
At most 2 * 105 calls will be made to set and get.
-------------------------------------------------------------------------------------------
*/
package Problems.TimeBasedKeyValueStore;

import java.util.*;

public class TimeBasedKeyValueStore {

    /*
     * TC : O(LogN)
     * SC : O(1)
    */
    HashMap<String, List<Value_Class>> map;

    private class Value_Class {
        String value;
        int timestamp;

        private Value_Class(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!this.map.containsKey(key)) {
            map.put(key, new ArrayList<Value_Class>());
        }
        map.get(key).add(new Value_Class(value, timestamp));
        // System.out.println("Map : " + map);
    }

    public String get(String key, int timestamp) {
        return this.map.containsKey(key) ? search(this.map.get(key), timestamp) : "";
    }

    public String search(List<Value_Class> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = start + ((end - start + 1) / 2);
            if (list.get(mid).timestamp == timestamp)
                return list.get(mid).value;
            if (list.get(mid).timestamp < timestamp) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return list.get(start).timestamp <= timestamp ? list.get(start).value : "";
    }
}