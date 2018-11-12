/*
136. Single Number

https://leetcode.com/problems/single-number/description/

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
/*
Idea - Iterate through the array and store the counts in map. Now iterate through the map and return the key whose value is 1
*/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        for (int key:m.keySet())
        {
            if(m.get(key)==1)
                return key;
        }
        return 0;
    }
}
/*
Time Complexity - O(n)
Space Complexity - O(n) - HashMap is used
*/
